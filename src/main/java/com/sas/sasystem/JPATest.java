package com.sas.sasystem;

import com.sas.sasystem.configuration.Constants;
import com.sas.sasystem.entities.*;
import com.sas.sasystem.repository.ExpertRepository;
import com.sas.sasystem.repository.MarketRepository;
import com.sas.sasystem.repository.ProductRepository;
import com.sas.sasystem.repository.UserRepository;
import com.sas.sasystem.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

//@Component
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
    @Autowired
    private IIndicatorService indicatorService;
    @Autowired
    private IQueryService queryService;
    @Autowired
    private ISampleItemReportService sampleItemReportService;
    @Autowired
    private ISampleItemService sampleItemService;
    @Autowired
    private ISampleTaskService sampleTaskService;
    @Autowired
    private ISATaskService saTaskService;

    @Override
    public void run(String... args) throws Exception {
        log.info("JPATest START");
        User manager1 = userRepository.findByUserName("marketmanager1");
        User manager2 = userRepository.findByUserName("marketmanager2");

        Expert expert1 = expertRepository.findExpertByUserName("expert1");
        Expert expert2 = expertRepository.findExpertByUserName("expert2");

        Market market1 = marketRepository.findMarketByMarketName("market1");
        Market market2 = marketRepository.findMarketByMarketName("market2");

        Product product1 = productRepository.findProductByProductName("product1");
        Product product2 = productRepository.findProductByProductName("product2");
        Product product3 = productRepository.findProductByProductName("product3");
        Product product4 = productRepository.findProductByProductName("product4");

        Constants constants = new Constants(manager1, manager2, expert1, expert2, market1, market2, product1, product2, product3, product4);

        SampleItemReport sampleItemReport = sampleItemReportService.makeNewReport(1, 5, new Date(), "123");
        sampleItemReportService.submitReport(sampleItemReport);

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
