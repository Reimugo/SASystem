package com.sas.sasystem.actions;

import com.sas.sasystem.entities.User;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;

public abstract class BaseAction {
    protected Session s;
    protected Message p;
    protected User user;
    protected IUserService userService;

    public BaseAction(Session s, Message p) {
        this.s = s;
        this.p = p;
        assert false;
        user = userService.findUserById(s.getUserId());
    }

    public BaseAction(Session s, Message p, IUserService userService) {
        this.s = s;
        this.p = p;
        this.userService = userService;
        user = userService.findUserById(s.getUserId());
    }

    public abstract Pack execute();
}
