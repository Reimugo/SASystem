package com.sas.sasystem.service;

import com.sas.sasystem.entities.User;

public interface IUserService {
    User findUser(int id);

    void createUser(User user);
}
