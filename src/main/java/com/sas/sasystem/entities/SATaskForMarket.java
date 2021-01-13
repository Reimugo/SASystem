package com.sas.sasystem.entities;

import java.util.Date;

public class SATaskForMarket extends SATask{
    public SATaskForMarket(String name, User manager, Date deadline, String description) {
        super(name, manager, deadline, description);
    }
}
