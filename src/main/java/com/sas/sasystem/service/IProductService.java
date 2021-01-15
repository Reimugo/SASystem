package com.sas.sasystem.service;

import com.sas.sasystem.entities.Product;

public interface IProductService {
    Product findProductByName(String productName);

    Product findProductById(int id);
}
