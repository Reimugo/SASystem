package com.sas.sasystem.actions.sampleItem;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.entities.SATaskForExpert;
import com.sas.sasystem.entities.SampleItem;
import com.sas.sasystem.entities.SampleTask;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.ISampleItemService;
import com.sas.sasystem.service.ISampleTaskService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

import java.util.ArrayList;

public class ListUnfinishedForExpertAction extends BaseAction {
    private ISATaskService saTaskService;
    private ISampleTaskService sampleTaskService;
    private ISampleItemService sampleItemService;

    public ListUnfinishedForExpertAction(Session s, Message p) {
        super(s, p);
    }

    @Override
    public void execute() {
        ArrayList<SATaskForExpert> saTasks = saTaskService.findUnfinishedSATasksForExpert(user);
        ArrayList<SampleTask> unfinishedSampleTasks = new ArrayList<>();
        ArrayList<SampleItem> unfinishedSampleItems = new ArrayList<>();
        for (SATaskForExpert saTask : saTasks){
            unfinishedSampleTasks.addAll(sampleTaskService.findUnfinishedSampleTasks(saTask));
        }
        for (SampleTask sampleTask : unfinishedSampleTasks) {
            unfinishedSampleItems.addAll(sampleItemService.findUnfinishedSampleItems(sampleTask));
        }
    }
}
