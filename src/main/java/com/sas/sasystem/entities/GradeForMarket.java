package com.sas.sasystem.entities;

public class GradeForMarket extends Grade{
    private Market market;
    private SampleTask sampleTask;

    public GradeForMarket(int grade, Market market, SampleTask sampleTask) {
        this.grade = grade;
        this.market = market;
        this.sampleTask = sampleTask;
    }

    public Market getMarket() {
        return market;
    }

    public SampleTask getSampleTask() {
        return sampleTask;
    }
}
