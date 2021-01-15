package com.sas.sasystem.service;

import com.sas.sasystem.entities.Expert;
import com.sas.sasystem.entities.User;

public interface IUserService {
    User findUserById(int id);

    User findUserByName(String username);

    Expert findExpertByName(String username);
}
