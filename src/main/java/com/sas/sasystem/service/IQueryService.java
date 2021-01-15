package com.sas.sasystem.service;

import java.util.Date;

public interface IQueryService {
    int queryOffQuantity(int productId, Date startDate, Date endDate);
}
