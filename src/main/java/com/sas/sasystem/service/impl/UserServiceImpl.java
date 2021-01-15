package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.User;
import com.sas.sasystem.repository.UserRepository;
import com.sas.sasystem.service.IUserService;

import java.util.Optional;

public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(int id) {
        Optional<User> user= userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User findUserByName(String username) {
        return userRepository.findByUserName(username);
    }


}
