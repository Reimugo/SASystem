package com.sas.sasystem.repository;

import com.sas.sasystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
}
