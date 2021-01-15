package com.sas.sasystem.actions.query;

import com.sas.sasystem.view.Message;
import com.sas.sasystem.view.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryOffQuantityActionTest {
    Session session;
    Message message;
    private QueryOffQuantityAction queryOffQuantityAction;

    @BeforeEach
    void setUp() {
        queryOffQuantityAction = new QueryOffQuantityAction(session, message);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        queryOffQuantityAction.execute();
    }
}
