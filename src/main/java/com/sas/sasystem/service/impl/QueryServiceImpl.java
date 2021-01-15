package com.sas.sasystem.service.impl;

import com.sas.sasystem.configuration.Constants;
import com.sas.sasystem.entities.SampleItemReport;
import com.sas.sasystem.repository.ProductRepository;
import com.sas.sasystem.service.IQueryService;

import java.util.ArrayList;
import java.util.Date;

public class QueryServiceImpl implements IQueryService {

    private ArrayList<SampleItemReport> itemReports= Constants.getInstance().itemReports;

    private ProductRepository productRepository;


    @Override
    public int queryOffQuantity(int productId, Date startDate, Date endDate) {
        int quantity = 0;
        for (SampleItemReport report: itemReports
             ) {
            if(report.getSampleItem().getProduct() == productRepository.findById(productId).orElse(null)) {
                Date date = report.getSampleDate();
                if(date.after(startDate) && date.before(endDate)){
                    quantity += report.getOffQuantity();
                }
            }

        }
        return quantity;
    }
}