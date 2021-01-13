package com.sas.sasystem.actions.satask;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.entities.SATaskForExpert;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

import java.util.ArrayList;

public class ListUnfinishedSATasksForExpertAction extends BaseAction {
    private ISATaskService saTaskService;

    public ListUnfinishedSATasksForExpertAction(Session s, Message p) {
        super(s, p);
    }

    @Override
    public void execute() {
        ArrayList<SATaskForExpert> saTasks = saTaskService.findSATasksForExpert(user);
        ArrayList<SATaskForExpert> unfinished = new ArrayList<>();
        for (SATaskForExpert saTask : saTasks){
            if (!saTask.isFinished()) {
                unfinished.add(saTask);
            }
        }
    }
}
