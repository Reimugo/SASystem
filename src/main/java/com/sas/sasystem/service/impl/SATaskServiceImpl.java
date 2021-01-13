package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.ISATaskService;

import java.util.ArrayList;
import java.util.Date;

public class SATaskServiceImpl implements ISATaskService {
    @Override
    public void releaseSATaskForMarket(SATaskForMarket saTaskForMarket) {

    }

    @Override
    public SATaskForMarket makeNewSATaskForMarket(String name, User saUser, ArrayList<Market> markets, ArrayList<Product> products, Date deadline, String description) {
        SATaskForMarket saTaskForMarket = new SATaskForMarket(name, saUser, deadline, description);
        completeSATask(saTaskForMarket, markets, products);
        return saTaskForMarket;
    }

    @Override
    public void releaseSATaskForExpert(SATaskForExpert saTaskForExpert) {

    }

    @Override
    public SATaskForExpert makeNewSATaskForExpert(String name, User saUser, ArrayList<Market> markets, ArrayList<Product> products, Date deadline, String description, User expert) {
        SATaskForExpert saTaskForExpert = new SATaskForExpert(name, saUser, deadline, description, expert);
        completeSATask(saTaskForExpert, markets, products);
        return saTaskForExpert;
    }

    @Override
    public ArrayList<SATaskForExpert> findSATasksForExpert(User expert) {
        return null;
    }

    @Override
    public ArrayList<SATaskForMarket> findSATasksForMarket() {
        return null;
    }

    @Override
    public SATask findSATask(String taskName) {
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
