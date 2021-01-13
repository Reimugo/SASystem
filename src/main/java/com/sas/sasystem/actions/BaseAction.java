package com.sas.sasystem.actions;

import com.sas.sasystem.entities.User;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;

public abstract class BaseAction {
    protected Session s;
    protected Message p;
    protected User user;
    protected IUserService userService;

    public BaseAction(Session s, Message p) {
        this.s = s;
        this.p = p;
        user = userService.findUser(s.getUserId());
    }

    public abstract void execute();
}
