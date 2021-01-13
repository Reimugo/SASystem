package com.sas.sasystem.actions.releaseSATask;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.IMarketService;
import com.sas.sasystem.service.IProductService;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

public class ReleaseForExpertAction extends ReleaseAction {
    public ReleaseForExpertAction(Session s, Message p) {
        super(s, p);
    }

    public void releaseForExpert() {
        SATaskForExpert saTaskForExpert = saTaskService.makeNewSATaskForExpert(taskName, user, markets, products, deadline, description, expert);
        saTaskService.releaseSATaskForExpert(saTaskForExpert);
    }

    @Override
    public void execute(){
        releaseForExpert();
    }
}
