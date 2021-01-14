package com.sas.sasystem.entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Market.findByMarketName", query = "SELECT m from Market m where m.marketName = :marketName")
public class Market extends AbstractBaseEntity{
    @Column(unique = true, nullable = false, updatable = false, length = 40)
    private String marketName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User manager;

    public Market(String marketName, User manager) {
        this.marketName = marketName;
    }

    public Market() {

    }

    public String getMarketName() {
        return marketName;
    }

    public User getManager() {
        return manager;
    }
}
