package com.sas.sasystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@NamedQuery(name = "User.findByUserName", query = "SELECT u from User u where u.userName = :userName")
public class User extends AbstractBaseEntity{
    @Column(unique = true, nullable = false, length = 40)
    private String userName;

    private boolean isSAUser;

    private boolean isExpert;

    private boolean isMarketManager;

    public User(String userName) {
        this.userName = userName;
        this.isSAUser = false;
        this.isExpert = false;
        this.isMarketManager = false;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
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

    public void setUserName(String name) {
        this.userName = name;
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
