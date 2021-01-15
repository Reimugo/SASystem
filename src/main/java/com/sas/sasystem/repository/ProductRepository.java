package com.sas.sasystem.repository;

import com.sas.sasystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByProductName(String productName);
}
