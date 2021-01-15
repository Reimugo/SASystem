package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.SampleItemReport;
import com.sas.sasystem.repository.SampleItemRepository;
import com.sas.sasystem.repository.impl.SampleItemRepositoryImpl;
import com.sas.sasystem.service.ISampleItemReportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class SampleItemReportServiceImpl implements ISampleItemReportService {

    private ArrayList<SampleItemReport> sampleItemReports;

    SampleItemRepository sampleItemRepository = new SampleItemRepositoryImpl();

    @Override
    public void submitReport(SampleItemReport report) {
        sampleItemReports.add(report);
    }

    @Override
    public SampleItemReport makeNewReport(int sampleItemId, int offQuantity, Date sampleDate, String description) {
        return new SampleItemReport(sampleItemRepository.findItemById(sampleItemId),offQuantity,sampleDate,description);
    }

    public SampleItemReportServiceImpl(ArrayList<SampleItemReport> sampleItemReports) {
        this.sampleItemReports = sampleItemReports;
    }

    public void setSampleItemReports(ArrayList<SampleItemReport> sampleItemReports) {
        this.sampleItemReports = sampleItemReports;
    }
}
