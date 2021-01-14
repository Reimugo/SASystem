package com.sas.sasystem.actions.satask;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.service.ISampleTaskService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

public class ListUnfinishedSATasksForMarketAction extends BaseAction {
    private ISampleTaskService sampleTaskService;

    public ListUnfinishedSATasksForMarketAction(Session s, Message p) {
        super(s, p);
    }

    @Override
    public void execute() {
    }
}
