package com.sas.sasystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "User.findByProductName", query = "SELECT p from Product p where p.productName = :productName")
public class Product extends AbstractBaseEntity{
    @Column(unique = true, nullable = false, updatable = false, length = 40)
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public Product() {

    }

    public String getProductName() {
        return productName;
    }
}
