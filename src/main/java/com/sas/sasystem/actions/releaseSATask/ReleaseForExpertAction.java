package com.sas.sasystem.actions.releaseSATask;

import com.sas.sasystem.entities.SATaskForExpert;
import com.sas.sasystem.service.IMarketService;
import com.sas.sasystem.service.IProductService;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

public class ReleaseForExpertAction extends ReleaseAction {
    public ReleaseForExpertAction(Session s, Message p, IUserService userService, ISATaskService saTaskService, IMarketService marketService, IProductService productService) {
        super(s, p, userService, saTaskService, marketService, productService);
    }

    @Override
    public Pack execute(){
        SATaskForExpert saTaskForExpert = saTaskService.makeNewSATaskForExpert(taskName, user, markets, products, deadline, description, expert);
        saTaskService.releaseSATaskForExpert(saTaskForExpert);
        return new Pack();
    }
}
