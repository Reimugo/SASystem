package com.sas.sasystem.entities;

public class User {
    private String name;
    private int id;
    private boolean isSAUser;
    private boolean isExpert;
    private boolean isMarketManager;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.isSAUser = false;
        this.isExpert = false;
        this.isMarketManager = false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isSAUser() {
        return isSAUser;
    }

    public boolean isExpert() {
        return isExpert;
    }

    public boolean isMarketManager() {
        return isMarketManager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSAUser(boolean SAUser) {
        isSAUser = SAUser;
    }

    public void setExpert(boolean expert) {
        isExpert = expert;
    }

    public void setMarketManager(boolean marketManager) {
        isMarketManager = marketManager;
    }
}
