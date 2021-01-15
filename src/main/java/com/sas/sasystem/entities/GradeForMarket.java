package com.sas.sasystem.entities;

public class GradeForMarket extends Grade{
    private Market market;
    private SampleTask sampleTask;

    public GradeForMarket(int num, String description, SampleTask sampleTask) {
        super(num, description);
        this.market = sampleTask.getMarket();
        this.sampleTask = sampleTask;
    }

    public Market getMarket() {
        return market;
    }

    public SampleTask getSampleTask() {
        return sampleTask;
    }
}
