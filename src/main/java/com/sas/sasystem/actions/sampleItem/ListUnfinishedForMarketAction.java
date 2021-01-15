package com.sas.sasystem.actions.sampleItem;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.*;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

import java.util.ArrayList;

public class ListUnfinishedForMarketAction extends BaseAction {
    private ISATaskService saTaskService;
    private IMarketService marketService;
    private ISampleTaskService sampleTaskService;
    private ISampleItemService sampleItemService;

    public ListUnfinishedForMarketAction(Session s, Message p, IUserService userService, IMarketService marketService, ISATaskService saTaskService, ISampleTaskService sampleTaskService, ISampleItemService sampleItemService) {
        super(s, p, userService);
        this.marketService = marketService;
        this.saTaskService = saTaskService;
        this.sampleTaskService = sampleTaskService;
        this.sampleItemService = sampleItemService;
    }

    @Override
    public Pack execute() {
        Market market = marketService.findMarketByManager(user);
        ArrayList<SATaskForMarket> saTasks = saTaskService.findUnfinishedSATasksForMarket();
        ArrayList<SampleTask> unfinishedSampleTasks = new ArrayList<>();
        ArrayList<SampleItem> unfinishedSampleItems = new ArrayList<>();
        for (SATaskForMarket saTask : saTasks) {
            unfinishedSampleTasks.addAll(sampleTaskService.findUnfinishedSampleTasks(saTask, market));
        }
        for (SampleTask sampleTask : unfinishedSampleTasks) {
            unfinishedSampleItems.addAll(sampleItemService.findUnfinishedSampleItems(sampleTask));
        }

        Pack pack = new Pack();
        for (int i = 0; i < unfinishedSampleItems.size(); i++) {
            pack.put(String.valueOf(i), unfinishedSampleItems.get(i));
        }
        return pack;
    }
}
