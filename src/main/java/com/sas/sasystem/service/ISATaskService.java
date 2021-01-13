package com.sas.sasystem.service;

import com.sas.sasystem.entities.*;

import java.util.ArrayList;
import java.util.Date;

public interface ISATaskService {
    void releaseSATaskForMarket(SATaskForMarket saTaskForMarket);

    SATaskForMarket makeNewSATaskForMarket(String name, User saUser, ArrayList<Market> markets, ArrayList<Product> products, Date deadline, String description);

    void releaseSATaskForExpert(SATaskForExpert saTaskForExpert);

    SATaskForExpert makeNewSATaskForExpert(String name, User saUser, ArrayList<Market> markets, ArrayList<Product> products, Date deadline, String description, User expert);

    ArrayList<SATaskForExpert> findSATasksForExpert(User expert);

    ArrayList<SATaskForMarket> findSATasksForMarket();

    SATask findSATask(String taskName);

}
