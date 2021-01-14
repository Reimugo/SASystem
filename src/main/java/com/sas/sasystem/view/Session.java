package com.sas.sasystem.view;

import com.sas.sasystem.entities.User;

public class Session {
    private User user;

    public Session() {
        this.user = null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return user.getId();
    }

    public String getUserName() {
        return user.getUserName();
    }

    public String getUserStatus() {
        if (user.isSAUser()) {
            return "监管任务责任人";
        }
        if (user.isExpert()) {
            return "专家";
        }
        if (user.isMarketManager()) {
            return "市场负责人";
        }
        else {
            return "访客";
        }
    }
}
