package com.sas.sasystem.actions.report;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.entities.SampleItemReport;
import com.sas.sasystem.service.ISampleItemReportService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.util.DateTimeUtils;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

import java.util.Date;

public class SubmitReportAction extends BaseAction {
    private ISampleItemReportService sampleItemReportService;

    public SubmitReportAction(Session s, Message p, IUserService userService, ISampleItemReportService sampleItemReportService) {
        super(s, p, userService);
        this.sampleItemReportService = sampleItemReportService;
    }

    @Override
    public Pack execute() {
        int sampleItemId = Integer.parseInt(p.get("SampleItemId"));
        int offQuantity = Integer.parseInt(p.get("OffQuantity"));
        Date sampleDate = DateTimeUtils.parse(p.get("SampleDate"));
        String description = p.get("description");
        SampleItemReport report = sampleItemReportService.makeNewReport(sampleItemId, offQuantity, sampleDate, description);
        sampleItemReportService.submitReport(report);
        Pack pack = new Pack();
        pack.put("SampleItemId", sampleItemId);
        return pack;
    }
}
