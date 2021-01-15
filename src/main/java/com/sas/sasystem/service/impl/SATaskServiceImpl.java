package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.ISATaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class SATaskServiceImpl implements ISATaskService {
    ArrayList<SATaskForMarket> saTasksForMarket;
    ArrayList<SATaskForExpert> saTasksForExpert;

    public SATaskServiceImpl(ArrayList<SATaskForMarket> saTasksForMarket, ArrayList<SATaskForExpert> saTasksForExpert) {
        this.saTasksForMarket = saTasksForMarket;
        this.saTasksForExpert = saTasksForExpert;
    }

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
            if(saTask.getExpert().getId().equals(expert.getId())){
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
            if(saTask.getExpert().getId().equals(expert.getId())  && (!saTask.isFinished())){
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

    public void setSaTasksForMarket(ArrayList<SATaskForMarket> saTasksForMarket) {
        this.saTasksForMarket = saTasksForMarket;
    }

    public void setSaTasksForExpert(ArrayList<SATaskForExpert> saTasksForExpert) {
        this.saTasksForExpert = saTasksForExpert;
    }
}
