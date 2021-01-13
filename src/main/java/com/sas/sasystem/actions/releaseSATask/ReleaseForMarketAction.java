package com.sas.sasystem.actions.releaseSATask;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.IMarketService;
import com.sas.sasystem.service.IProductService;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

public class ReleaseForMarketAction extends ReleaseAction {
    public ReleaseForMarketAction(Session s, Message p) {
        super(s, p);
    }

    @Override
    public void execute() {
        releaseForMarket();
    }

    public void releaseForMarket() {
        SATaskForMarket saTaskForMarket = saTaskService.makeNewSATaskForMarket(taskName, user, markets, products, deadline, description);
        saTaskService.releaseSATaskForMarket(saTaskForMarket);
    }
}
