package com.sas.sasystem;

import com.sas.sasystem.actions.query.QueryOffQuantityAction;
import com.sas.sasystem.actions.releaseSATask.ReleaseForMarketAction;
import com.sas.sasystem.actions.report.SubmitReportAction;
import com.sas.sasystem.actions.sampleItem.ListUnfinishedForExpertAction;
import com.sas.sasystem.actions.sampleItem.ListUnfinishedForMarketAction;
import com.sas.sasystem.configuration.Constants;
import com.sas.sasystem.entities.*;
import com.sas.sasystem.repository.*;
import com.sas.sasystem.repository.impl.SampleItemRepositoryImpl;
import com.sas.sasystem.service.*;
import com.sas.sasystem.service.impl.*;
import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Pack;
import com.sas.sasystem.view.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
class SasystemApplicationTests {
    Session session;
    Message message;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpertRepository expertRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MarketRepository marketRepository;
    private SampleItemRepository sampleItemRepository;

    @Autowired
    private IUserService userService;
    @Autowired
    private IMarketService marketService;
    @Autowired
    private IProductService productService;

    private IQueryService queryService;
    private IIndicatorService indicatorService;
    private ISampleItemReportService sampleItemReportService;
    private ISampleItemService sampleItemService;
    private ISampleTaskService sampleTaskService;
    private ISATaskService saTaskService;

    private ArrayList<SampleItem> unfinishedSampleItemsForMarket;
    private ArrayList<SampleItem> unfinishedSampleItemsForExpert;

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

        this.unfinishedSampleItemsForMarket = constants.unfinishedSampleItemsForMarket;
        this.unfinishedSampleItemsForExpert = constants.unfinishedSampleItemsForMarket;

        sampleItemRepository = new SampleItemRepositoryImpl(constants.sampleItems);

        queryService = new QueryServiceImpl(constants.itemReports);
        indicatorService = new IndicatorServiceImpl(constants.saTaskForExperts, constants.gradeForExperts, constants.saTaskForMarkets, constants.gradeForMarkets);
        sampleItemReportService = new SampleItemReportServiceImpl(constants.itemReports, sampleItemRepository);
        sampleItemService = new SampleItemServiceImpl(sampleItemRepository);
        sampleTaskService = new SampleTaskServiceImpl();
        saTaskService = new SATaskServiceImpl(constants.saTaskForMarkets, constants.saTaskForExperts);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void queryOffQuantity() {
        session = new Session(73);
        message = new Message();
        message.put("ProductId", "1");
        message.put("StartDate", "2020-1-1");
        message.put("EndDate", "2022-1-2");
        QueryOffQuantityAction queryOffQuantityAction = new QueryOffQuantityAction(session, message, userService, queryService);

        int res = (int) queryOffQuantityAction.execute().get("OffQuantity");

        Assertions.assertEquals(res, 6);
    }

    @Test
    void releaseSATaskForMarket() {
        session = new Session(73);
        message = new Message();
        message.put("TaskName", "pj3");
        message.put("Markets", "market5/market9");
        message.put("Products", "product1/product2/product8");
        message.put("Deadline", "2078-1-1");
        message.put("Description", "pj in 2078");
        ReleaseForMarketAction releaseForMarketAction = new ReleaseForMarketAction(session, message, userService, saTaskService, marketService, productService);

        releaseForMarketAction.execute();

    }

    @Test
    void releaseSATaskForExpert() {
        session = new Session(73);
        message = new Message();
        message.put("ExpertId", "2");
        message.put("TaskName", "pj3");
        message.put("Markets", "market5/market9");
        message.put("Products", "product1/product2/product8");
        message.put("Deadline", "2078-1-1");
        message.put("Description", "pj in 2078");
        ReleaseForMarketAction releaseForMarketAction = new ReleaseForMarketAction(session, message, userService, saTaskService, marketService, productService);

        releaseForMarketAction.execute();
    }

    @Test
    void listUnfinishedSampleItemsForMarket() {
        session = new Session(105);
        message = new Message();
        ListUnfinishedForMarketAction listUnfinishedForMarketAction = new ListUnfinishedForMarketAction(session, message, userService, marketService, saTaskService, sampleTaskService, sampleItemService);

        Pack res = listUnfinishedForMarketAction.execute();
        int size = res.getSize();
        boolean f = size == 3;
        if (f) {
            for (int i = 0; i < size; i++) {
                SampleItem sampleItem = (SampleItem) res.get(String.valueOf(i));
                boolean t = false;
                for (SampleItem s : unfinishedSampleItemsForMarket) {
                    if (sampleItem.getId().equals(s.getId())){
                        t = true;
                        break;
                    }
                }
                f &= t;
            }
        }

        Assertions.assertTrue(f);

    }

    @Test
    void listUnfinishedSampleItemsForExpert() {
        session = new Session(42);
        message = new Message();
        ListUnfinishedForExpertAction listUnfinishedForExpertAction = new ListUnfinishedForExpertAction(session, message, userService, saTaskService, sampleTaskService, sampleItemService);

        Pack res = listUnfinishedForExpertAction.execute();
        int size = res.getSize();
        boolean f = size == 3;
        if (f) {
            for (int i = 0; i < size; i++) {
                SampleItem sampleItem = (SampleItem) res.get(String.valueOf(i));
                boolean t = false;
                for (SampleItem s : unfinishedSampleItemsForExpert) {
                    if (sampleItem.getId().equals(s.getId())){
                        t = true;
                        break;
                    }
                }
                f &= t;
            }
        }

        Assertions.assertTrue(f);
    }

    @Test
    void finishSampleItemForMarket() {
        session = new Session(105);
        message = new Message();
        message.put("SampleItemId", "2");
        message.put("OffQuantity", "5");
        message.put("description", "sampleItemForMarket2");
        SubmitReportAction submitReportAction = new SubmitReportAction(session, message, userService, sampleItemReportService);

        Pack res = submitReportAction.execute();

        SampleItem sampleItem = sampleItemService.findSampleItem((Integer) res.get("SampleItemId"));
        Assertions.assertTrue(sampleItem.isFinished());
    }

    @Test
    void finishSampleItemForExpert() {
        session = new Session(41);
        message = new Message();
        message.put("SampleItemId", "6");
        message.put("OffQuantity", "5");
        message.put("description", "sampleItemForMarket6");
        SubmitReportAction submitReportAction = new SubmitReportAction(session, message, userService, sampleItemReportService);

        Pack res = submitReportAction.execute();

        SampleItem sampleItem = sampleItemService.findSampleItem((Integer) res.get("SampleItemId"));
        Assertions.assertTrue(sampleItem.isFinished());
    }

    @Test
    void finishTaskForExpert() {

    }

    @Test
    void unfinishTaskForExpert() {

    }

    @Test
    void finishTaskForMarket() {

    }

    @Test
    void unfinishTaskForMarket() {

    }

    @Test
    void gradeSystem() {

    }
}
