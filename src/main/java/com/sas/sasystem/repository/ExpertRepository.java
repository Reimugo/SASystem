package com.sas.sasystem.repository;

import com.sas.sasystem.entities.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository extends JpaRepository<Expert,Integer> {
    Expert findExpertByUserName(String userName);
}
