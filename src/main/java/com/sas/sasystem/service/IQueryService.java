package com.sas.sasystem.service;

import java.util.Date;

public interface IQueryService {
    int queryOffQuantity(int productName, Date startDate, Date endDate);
}
