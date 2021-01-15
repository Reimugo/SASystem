package com.sas.sasystem;

import com.sas.sasystem.actions.query.QueryOffQuantityAction;
import com.sas.sasystem.configuration.Constants;
import com.sas.sasystem.entities.Expert;
import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.Product;
import com.sas.sasystem.entities.User;
import com.sas.sasystem.repository.ExpertRepository;
import com.sas.sasystem.repository.MarketRepository;
import com.sas.sasystem.repository.ProductRepository;
import com.sas.sasystem.repository.UserRepository;
import com.sas.sasystem.service.*;
import com.sas.sasystem.service.impl.QueryServiceImpl;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SasystemApplicationTests {
    Session session;
    Message message;
    private QueryOffQuantityAction queryOffQuantityAction;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpertRepository expertRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private IUserService userService;

    private IQueryService queryService;
    private IIndicatorService indicatorService;
    private ISampleItemReportService sampleItemReportService;
    private ISampleItemService sampleItemService;
    private ISampleTaskService sampleTaskService;
    private ISATaskService saTaskService;

    private static final Logger log = LoggerFactory.getLogger(SasystemApplicationTests.class);

    @BeforeEach
    void setUp() {
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

        queryService = new QueryServiceImpl(constants.itemReports, productRepository);


        session = new Session(73);
        message = new Message();
        message.put("ProductId", "1");
        message.put("StartDate", "2020-1-1");
        message.put("EndDate", "2022-1-2");
        queryOffQuantityAction = new QueryOffQuantityAction(session, message, userService, queryService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        int res = (int) queryOffQuantityAction.execute().get("OffQuantity");
        log.info(String.valueOf(res));
    }
}
