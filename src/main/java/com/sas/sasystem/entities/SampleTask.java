package com.sas.sasystem.entities;

import java.util.ArrayList;
import java.util.Date;

public class SampleTask {
    private Market market;
    private ArrayList<SampleItem> sampleItems;
    private boolean isFinished;
    private Date finishDate;

    public SampleTask(Market market) {
        this.market = market;
        this.sampleItems = new ArrayList<>();
        this.isFinished = false;
        this.finishDate = null;
    }

    public Market getMarket() {
        return market;
    }

    public ArrayList<SampleItem> getSampleItems() {
        return sampleItems;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void addSampleItem(SampleItem sampleItem) {
        this.sampleItems.add(sampleItem);
    }
}
