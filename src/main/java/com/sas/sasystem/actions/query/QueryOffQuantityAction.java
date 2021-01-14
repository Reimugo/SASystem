package com.sas.sasystem.actions.query;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.service.IQueryService;
import com.sas.sasystem.util.DateTimeUtils;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

import java.util.Date;

public class QueryOffQuantityAction extends BaseAction {
    private IQueryService queryService;

    public QueryOffQuantityAction(Session s, Message p) {
        super(s, p);
    }

    @Override
    public void execute() {
        int productName = Integer.parseInt(p.get("ProductId"));
        Date startDate = DateTimeUtils.parse(p.get("StartDate"));
        Date endDate = DateTimeUtils.parse(p.get("EndDate"));
        queryService.queryOffQuantity(productName, startDate, endDate);
    }
}
