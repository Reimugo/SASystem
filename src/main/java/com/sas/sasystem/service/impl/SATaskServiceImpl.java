package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.ISATaskService;

import java.util.ArrayList;
import java.util.Date;

public class SATaskServiceImpl implements ISATaskService {

    //todo 得到专家和农贸市场的SATask的list
    ArrayList<SATaskForMarket> saTasksForMarket = new ArrayList<>();
    ArrayList<SATaskForExpert> saTasksForExpert = new ArrayList<>();


    @Override
    public void releaseSATaskForMarket(SATaskForMarket saTaskForMarket) {
        saTasksForMarket.add(saTaskForMarket);
    }

    @Override
    public SATaskForMarket makeNewSATaskForMarket(String name, User saUser, ArrayList<Market> markets, ArrayList<Product> products, Date deadline, String description) {
        SATaskForMarket saTaskForMarket = new SATaskForMarket(name, saUser, deadline, description);
        completeSATask(saTaskForMarket, markets, products);
        return saTaskForMarket;
    }

    @Override
    public void releaseSATaskForExpert(SATaskForExpert saTaskForExpert) {
        saTasksForExpert.add(saTaskForExpert);
    }

    @Override
    public SATaskForExpert makeNewSATaskForExpert(String name, User saUser, ArrayList<Market> markets, ArrayList<Product> products, Date deadline, String description, User expert) {
        SATaskForExpert saTaskForExpert = new SATaskForExpert(name, saUser, deadline, description, expert);
        completeSATask(saTaskForExpert, markets, products);
        return saTaskForExpert;
    }

    @Override
    public ArrayList<SATaskForExpert> findSATasksForExpert(User expert) {
        ArrayList<SATaskForExpert> ret = new ArrayList<>();
        for (SATaskForExpert saTask: saTasksForExpert
             ) {
            if(saTask.getExpert() == expert){
                ret.add(saTask);
            }
        }
        return ret;
    }

    @Override
    public ArrayList<SATaskForExpert> findUnfinishedSATasksForExpert(User expert) {
        ArrayList<SATaskForExpert> ret = new ArrayList<>();
        for (SATaskForExpert saTask: saTasksForExpert
        ) {
            if(saTask.getExpert() == expert && (!saTask.isFinished())){
                ret.add(saTask);
            }
        }
        return ret;
    }


    @Override
    public ArrayList<SATaskForMarket> findSATasksForMarket() {
        return saTasksForMarket;
    }

    @Override
    public ArrayList<SATaskForMarket> findUnfinishedSATasksForMarket() {
        ArrayList<SATaskForMarket> ret = new ArrayList<>();
        for (SATaskForMarket task: saTasksForMarket
             ) {
            if(!task.isFinished()){
                ret.add(task);
            }
        }
        return ret;
    }


    @Override
    public SATask findSATask(String taskName) {
        for (SATaskForMarket task: saTasksForMarket
             ) {
            if(task.getName().equals(taskName)){
                return task;
            }
        }

        for (SATaskForExpert task: saTasksForExpert
             ) {
            if(task.getName().equals(taskName)){
                return task;
            }
        }
        return null;
    }

    private void completeSATask(SATask saTask, ArrayList<Market> markets, ArrayList<Product> products) {
        for (Market market : markets) {
            SampleTask sampleTaskTmp = new SampleTask(market);
            for (Product product : products) {
                sampleTaskTmp.addSampleItem(new SampleItem(product));
            }
            saTask.addSampleTask(sampleTaskTmp);
        }
    }
}
