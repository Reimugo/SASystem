package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.Product;
import com.sas.sasystem.repository.ProductRepository;
import com.sas.sasystem.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductByName(String productName) {
        return productRepository.findProductByProductName(productName);
    }

    @Override
    public Product findProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
