package com.sas.sasystem.actions.sampleItem;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.entities.SATask;
import com.sas.sasystem.entities.SampleTask;
import com.sas.sasystem.entities.User;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.ISampleTaskService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

import java.util.ArrayList;

public class ListUnfinishedForExpertAction extends BaseAction {
    private ISATaskService saTaskService;
    private ISampleTaskService sampleTaskService;

    public ListUnfinishedForExpertAction(Session s, Message p) {
        super(s, p);
    }

    @Override
    public void execute() {


    }
}
