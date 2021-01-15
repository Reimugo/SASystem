package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.User;
import com.sas.sasystem.repository.MarketRepository;
import com.sas.sasystem.service.IMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketServiceImpl implements IMarketService {
    @Autowired
    private MarketRepository marketRepository;

    public MarketServiceImpl(MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @Override
    public Market findMarketByName(String marketName) {
        return marketRepository.findMarketByMarketName(marketName);
    }

    @Override
    public Market findMarketByManager(User marketManager) {
        return marketRepository.findMarketByManager(marketManager);
    }

    @Override
    public Market findMarketById(int id) {
        Optional<Market> market = marketRepository.findById(id);
        return market.orElse(null);
    }
}
