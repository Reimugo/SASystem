package com.sas.sasystem.actions.releaseSATask;

import com.sas.sasystem.actions.BaseAction;
import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.Product;
import com.sas.sasystem.entities.User;
import com.sas.sasystem.service.IMarketService;
import com.sas.sasystem.service.IProductService;
import com.sas.sasystem.service.ISATaskService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.util.DateTimeUtils;
import com.sas.sasystem.util.StringArrayUtils;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

import java.util.ArrayList;
import java.util.Date;

public abstract class ReleaseAction extends BaseAction {
    protected ISATaskService saTaskService;
    protected IMarketService marketService;
    protected IProductService productService;

    protected String taskName;
    protected ArrayList<Market> markets;
    protected ArrayList<Product> products;
    protected Date deadline;
    protected String description;
    protected User expert;

    public ReleaseAction(Session s, Message p, IUserService userService, ISATaskService saTaskService, IMarketService marketService, IProductService productService) {
        super(s, p, userService);
        this.saTaskService = saTaskService;
        this.marketService = marketService;
        this.productService = productService;

        taskName = p.get("TaskName");
        String[] marketNames = StringArrayUtils.parse(p.get("Markets"));
        markets = new ArrayList<>();
        for (String marketName : marketNames) {
            markets.add(marketService.findMarketByName(marketName));
        }
        String[] productNames = StringArrayUtils.parse(p.get("Products"));
        products = new ArrayList<>();
        for (String productName : productNames) {
            products.add(productService.findProductByName(productName));
        }
        deadline = DateTimeUtils.parse(p.get("Deadline"));
        description = p.get("Description");
        if (p.get("ExpertId") != null) {
            expert = userService.findUserById(Integer.parseInt(p.get("ExpertId")));
        }
    }

    @Override
    public abstract Pack execute();
}
