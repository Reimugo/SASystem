package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.Product;
import com.sas.sasystem.entities.SampleItemReport;
import com.sas.sasystem.repository.ProductRepository;
import com.sas.sasystem.service.IQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class QueryServiceImpl implements IQueryService {

    private ArrayList<SampleItemReport> itemReports;

    public QueryServiceImpl(ArrayList<SampleItemReport> itemReports, ProductRepository productRepository) {
        this.itemReports = itemReports;
        this.productRepository = productRepository;
    }

    @Autowired
    private ProductRepository productRepository;


    @Override
    public int queryOffQuantity(int productId, Date startDate, Date endDate) {
        int quantity = 0;
        for (SampleItemReport report: itemReports) {
            Product product = productRepository.findById(productId).get();
            if(report.getSampleItem().getProduct() == product) {
                Date date = report.getSampleDate();
                if(date.after(startDate) && date.before(endDate)){
                    quantity += report.getOffQuantity();
                }
            }

        }
        return quantity;
    }

    public void setItemReports(ArrayList<SampleItemReport> itemReports) {
        this.itemReports = itemReports;
    }
}
