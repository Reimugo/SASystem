package com.sas.sasystem.service.impl;

import com.sas.sasystem.dao.UserDao;
import com.sas.sasystem.dao.UserRepository;
import com.sas.sasystem.entities.User;
import com.sas.sasystem.service.IUserService;

public class UserServiceImpl implements IUserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUser(int id) {
        return null;
    }

    @Override
    public void createUser(User user) {
    }
}
