package com.sas.sasystem.entities;

import java.util.ArrayList;
import java.util.Date;

public class SATaskForExpert extends SATask{
    private User expert;

    public SATaskForExpert(String name, User manager, Date deadline, String description, User expert) {
        super(name, manager, deadline, description);
        this.expert = expert;
    }

    public User getExpert() {
        return expert;
    }

    public void setExpert(User expert) {
        this.expert = expert;
    }
}
