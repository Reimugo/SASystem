package com.sas.sasystem.service;

import com.sas.sasystem.entities.SampleItemReport;

public interface ISampleItemReportService {
    void submitReport(SampleItemReport report);

    SampleItemReport makeNewReport();
}
