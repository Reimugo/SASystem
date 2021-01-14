package com.sas.sasystem.dao;

import com.sas.sasystem.entities.User;

public interface UserDao {
    User findUser(String userName);
}
