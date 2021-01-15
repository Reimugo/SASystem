package com.sas.sasystem.repository;

import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market,Integer> {
    Market findMarketByMarketName(String marketName);

    Market findMarketByManager(User user);
}
