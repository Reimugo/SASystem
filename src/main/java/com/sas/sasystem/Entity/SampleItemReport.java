package com.sas.sasystem.Entity;

import java.util.Date;

public class SampleItemReport {
    private Product product;
    private int offQuantity;
    private Date sampleDate;
    private String description;
    private Date submitDate;

    public SampleItemReport(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getOffQuantity() {
        return offQuantity;
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setOffQuantity(int offQuantity) {
        this.offQuantity = offQuantity;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
