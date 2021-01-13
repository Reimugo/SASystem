package com.sas.sasystem.entities;

public class Market {
    private String name;
    private User manager;

    public Market(String name, User manager) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User getManager() {
        return manager;
    }
}
