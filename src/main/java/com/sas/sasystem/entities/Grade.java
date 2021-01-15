package com.sas.sasystem.entities;

import java.util.Date;

public class Grade {
    protected int num;
    protected String description;
    protected Date date;

    public Grade(int num, String description) {
        this.num = num;
        this.description = description;
        this.date = new Date();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
