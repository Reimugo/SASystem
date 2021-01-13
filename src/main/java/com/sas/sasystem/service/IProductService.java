package com.sas.sasystem.service;

import com.sas.sasystem.entities.Product;

public interface IProductService {
    Product findProduct(String productName);
}
