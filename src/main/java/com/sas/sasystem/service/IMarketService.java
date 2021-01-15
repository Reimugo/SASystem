package com.sas.sasystem.service;

import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.User;

public interface IMarketService {
    Market findMarketByName(String marketName);

    Market findMarketByManager(User marketManager);

    Market findMarketById(int id);
}
