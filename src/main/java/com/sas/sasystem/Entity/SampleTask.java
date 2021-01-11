package com.sas.sasystem.Entity;

import java.util.ArrayList;
import java.util.Date;

public class SampleTask {
    private Market market;
    private ArrayList<SampleItem> sampleItems;
    private boolean isComplete;
    private Date completeDate;

    public SampleTask(Market market) {
        this.market = market;
    }

    public Market getMarket() {
        return market;
    }

    public ArrayList<SampleItem> getSampleItems() {
        return sampleItems;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public Date getCompleteDate() {
        return completeDate;
    }
}
