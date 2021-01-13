package com.sas.sasystem.entities;

import java.util.Date;

public class SampleItemReport {
    private SampleItem sampleItem;
    private int offQuantity;
    private Date sampleDate;
    private String description;
    private Date submitDate;

    public SampleItemReport(SampleItem sampleItem, int offQuantity, Date sampleDate, String description) {
        this.sampleItem = sampleItem;
        this.offQuantity = offQuantity;
        this.sampleDate = sampleDate;
        this.description = description;
        this.submitDate = null;
    }

    public SampleItem getSampleItem() {
        return sampleItem;
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

    public void submit() {
        if (sampleItem.isFinished()) {
            return;
        }
        if (submitDate != null) {
            return;
        }
        submitDate = new Date();
        sampleItem.setReport(this);
    }
}
