package com.sas.sasystem.service;

import com.sas.sasystem.entities.SampleItemReport;

import java.util.Date;

public interface ISampleItemReportService {
    void submitReport(SampleItemReport report);

    SampleItemReport makeNewReport(int sampleItemId, int offQuantity, Date sampleDate, String description);
}
