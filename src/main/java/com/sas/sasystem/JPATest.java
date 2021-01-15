package com.sas.sasystem;

import com.sas.sasystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JPATest implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JPATest.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("JPATest START");

        log.info(userRepository.findByUserName("user1").getUserName());
//        User user = new User("user4");
//        userRepository.save(user);
//
//        log.info(userRepository.findAll().get(0).getUserName());
//        userRepository.delete(user);
        log.info("JPATest END");
    }
}
