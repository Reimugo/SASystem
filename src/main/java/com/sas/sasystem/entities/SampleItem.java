package com.sas.sasystem.entities;

public class SampleItem {
    private Product product;
    private SampleItemReport report;
    private boolean isFinished;

    public SampleItem(Product product) {
        this.product = product;
        this.report = null;
        this.isFinished = false;
    }

    public Product getProduct() {
        return product;
    }

    public SampleItemReport getReport() {
        return report;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setReport(SampleItemReport report) {
        this.report = report;
        this.isFinished = true;
    }
}
