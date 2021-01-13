package com.sas.sasystem.service;

import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.User;

public interface IMarketService {
    Market findMarket(String marketName);

    Market findMarket(User marketManager);
}
