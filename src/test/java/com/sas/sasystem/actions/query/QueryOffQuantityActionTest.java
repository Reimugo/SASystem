package com.sas.sasystem.actions.query;

import com.sas.sasystem.service.IQueryService;
import com.sas.sasystem.service.IUserService;
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
class QueryOffQuantityActionTest {
    Session session;
    Message message;
    private QueryOffQuantityAction queryOffQuantityAction;
    @Autowired
    private IUserService userService;
    private IQueryService queryService;

    private static final Logger log = LoggerFactory.getLogger(QueryOffQuantityActionTest.class);

    @BeforeEach
    void setUp() {
        session = new Session(73);
        message = new Message();
        message.put("ProductId", "1");
        message.put("StartDate", "2000-1-1");
        message.put("EndDate", "2000-1-2");
        queryOffQuantityAction = new QueryOffQuantityAction(session, message, userService, queryService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        int res = (int) queryOffQuantityAction.execute().get("OffQuantity");
    }
}
