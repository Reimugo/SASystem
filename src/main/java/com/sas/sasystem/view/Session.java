package com.sas.sasystem.view;

public class Session {
    private String userName;
    private int userId;

    public Session(int userId) {
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }
}
