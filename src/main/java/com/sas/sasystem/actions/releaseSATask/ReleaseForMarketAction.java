package com.sas.sasystem.actions.releaseSATask;

import com.sas.sasystem.entities.SATaskForMarket;
import com.sas.sasystem.service.IMarketService;
import com.sas.sasystem.service.IProductService;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

public class ReleaseForMarketAction extends ReleaseAction {
    public ReleaseForMarketAction(Session s, Message p, IUserService userService, ISATaskService saTaskService, IMarketService marketService, IProductService productService) {
        super(s, p, userService, saTaskService, marketService, productService);
    }

    @Override
    public Pack execute() {
        SATaskForMarket saTaskForMarket = saTaskService.makeNewSATaskForMarket(taskName, user, markets, products, deadline, description);
        saTaskService.releaseSATaskForMarket(saTaskForMarket);
        return new Pack();
    }
}
