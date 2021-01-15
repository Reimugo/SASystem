package com.sas.sasystem.entities;

public class SampleItem extends AbstractBaseEntity{
    private Product product;
    private SampleItemReport report;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    private boolean isFinished;

    public SampleItem(Product product) {
        this.product = product;
        this.report = null;
        this.isFinished = false;
    }

    public SampleItem(Product product, int i) {
        this.product = product;
        this.report = null;
        this.isFinished = false;
        this.id = i;
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
