package com.sas.sasystem.actions.query;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.service.IQueryService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.util.DateTimeUtils;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

import java.util.Date;

public class QueryOffQuantityAction extends BaseAction {
    private IQueryService queryService;

    public QueryOffQuantityAction(Session s, Message p) {
        super(s, p);
    }

    public QueryOffQuantityAction(Session s, Message p, IUserService userService, IQueryService queryService) {
        super(s, p, userService);
        this.queryService = queryService;
    }

    @Override
    public Pack execute() {
        int productName = Integer.parseInt(p.get("ProductId"));
        Date startDate = DateTimeUtils.parse(p.get("StartDate"));
        Date endDate = DateTimeUtils.parse(p.get("EndDate"));
        int res = queryService.queryOffQuantity(productName, startDate, endDate);
        Pack pack = new Pack();
        pack.put("OffQuantity", res);
        return pack;
    }
}
