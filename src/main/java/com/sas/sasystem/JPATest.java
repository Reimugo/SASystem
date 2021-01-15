package com.sas.sasystem;

import com.sas.sasystem.repository.ExpertRepository;
import com.sas.sasystem.repository.MarketRepository;
import com.sas.sasystem.repository.ProductRepository;
import com.sas.sasystem.repository.UserRepository;
import com.sas.sasystem.service.IUserService;
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
    @Autowired
    private ExpertRepository expertRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MarketRepository marketRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("JPATest START");

//        log.info(userRepository.findByUserName("user1").getUserName());
//        Expert expert = new Expert("expert1");
//        expert.setScore(5);
//        expertRepository.save(expert);
//        User user = new User("user4");
//        userRepository.save(user);
        log.info(marketRepository.findMarketByMarketName("market1").getManager().getUserName());
//        log.info("" + expertRepository.findExpertByUserName("expert1").getScore());
//        log.info("" + userService.findUserByName("expert1").getUserName());
//        userRepository.delete(user);
        log.info("JPATest END");
    }
}
