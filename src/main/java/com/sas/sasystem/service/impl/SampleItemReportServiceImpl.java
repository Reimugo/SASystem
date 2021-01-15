package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.SampleItemReport;
import com.sas.sasystem.repository.SampleItemRepository;
import com.sas.sasystem.service.ISampleItemReportService;

import java.util.ArrayList;
import java.util.Date;

public class SampleItemReportServiceImpl implements ISampleItemReportService {

    private ArrayList<SampleItemReport> sampleItemReports;

    SampleItemRepository sampleItemRepository;

    @Override
    public void submitReport(SampleItemReport report) {
        sampleItemReports.add(report);
        report.submit();
    }

    @Override
    public SampleItemReport makeNewReport(int sampleItemId, int offQuantity, Date sampleDate, String description) {
        return new SampleItemReport(sampleItemRepository.findItemById(sampleItemId),offQuantity,sampleDate,description);
    }

    public SampleItemReportServiceImpl(ArrayList<SampleItemReport> sampleItemReports, SampleItemRepository sampleItemRepository) {
        this.sampleItemReports = sampleItemReports;
        this.sampleItemRepository = sampleItemRepository;
    }

    public void setSampleItemReports(ArrayList<SampleItemReport> sampleItemReports) {
        this.sampleItemReports = sampleItemReports;
    }
}
