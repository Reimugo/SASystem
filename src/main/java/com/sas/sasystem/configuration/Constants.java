package com.sas.sasystem.configuration;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.IMarketService;
import com.sas.sasystem.service.IProductService;
import com.sas.sasystem.service.IUserService;
import com.sas.sasystem.service.impl.UserServiceImpl;
import com.sas.sasystem.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Constants {
    private Constants(){

    }

    private static Constants instance = null;

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }


    private IUserService userService;

    private IMarketService marketService;
    private IProductService productService;

    User manager = userService.findUserByName("user1");
    Expert expert1 = userService.findExpertByName("expert1");
    Expert expert2 = userService.findExpertByName("expert2");
    Market market1 = marketService.findMarketById(1);
    Market market2 = marketService.findMarketById(2);
    Product product1 = productService.findProductById(1);
    Product product2 = productService.findProductById(2);

    public ArrayList<GradeForExpert> gradeForExperts = new ArrayList<>();
    public ArrayList<GradeForMarket> gradeForMarkets = new ArrayList<>();

    public ArrayList<SampleItemReport> itemReports = new ArrayList<>();


    public ArrayList<SATaskForExpert> saTaskForExperts = createExpertSATasks();
    public ArrayList<SATaskForMarket> saTaskForMarkets = createMarketSATasks();


    private ArrayList<SATaskForMarket> createMarketSATasks(){
        SampleItem sampleItem1 = new SampleItem(product1);
        SampleItemReport sampleItemReport1 = new SampleItemReport(sampleItem1,3,DateTimeUtils.parse("2021-01-16"),"report1");
        sampleItemReport1.submit();
        SampleTask sampleTask1 = new SampleTask(market1);
        sampleTask1.addSampleItem(sampleItem1);

        SampleItem sampleItem2 = new SampleItem(product2);
        SampleTask sampleTask2 = new SampleTask(market2);
        sampleTask2.addSampleItem(sampleItem2);

        SATaskForMarket saTaskForMarket1 = new SATaskForMarket("pj1",manager,DateTimeUtils.parse("2021-01-31"),"OOAD-pj1");
        saTaskForMarket1.setFinished(true);
        saTaskForMarket1.setFinishDate(DateTimeUtils.parse("2021-01-16"));
        saTaskForMarket1.addSampleTask(sampleTask1);

        SATaskForMarket saTaskForMarket2 = new SATaskForMarket("pj2",manager,DateTimeUtils.parse("2021-01-31"),"OOAD-pj2");
        saTaskForMarket2.addSampleTask(sampleTask2);

        ArrayList<SATaskForMarket> saTaskForMarkets = new ArrayList<>();
        saTaskForMarkets.add(saTaskForMarket1);
        saTaskForMarkets.add(saTaskForMarket2);

        return saTaskForMarkets;
    }

    private ArrayList<SATaskForExpert> createExpertSATasks(){
        SampleItem sampleItem1 = new SampleItem(product1);
        SampleItemReport sampleItemReport1 = new SampleItemReport(sampleItem1,3,DateTimeUtils.parse("2021-01-16"),"report1");
        sampleItemReport1.submit();
        SampleTask sampleTask1 = new SampleTask(market1);
        sampleTask1.addSampleItem(sampleItem1);

        SampleItem sampleItem2 = new SampleItem(product2);
        SampleTask sampleTask2 = new SampleTask(market2);
        sampleTask2.addSampleItem(sampleItem2);

        SATaskForExpert saTaskForExpert1 = new SATaskForExpert("expertTask1",manager,DateTimeUtils.parse("2021-01-31"),"expertTask1",expert1);
        saTaskForExpert1.setFinished(true);
        saTaskForExpert1.setFinishDate(DateTimeUtils.parse("2021-01-16"));
        saTaskForExpert1.addSampleTask(sampleTask1);

        SATaskForExpert saTaskForExpert2 = new SATaskForExpert("expertTask2",manager,DateTimeUtils.parse("2021-01-31"),"expertTask2",expert2);
        saTaskForExpert2.addSampleTask(sampleTask2);

        ArrayList<SATaskForExpert> saTaskForExperts = new ArrayList<>();
        saTaskForExperts.add(saTaskForExpert1);
        saTaskForExperts.add(saTaskForExpert2);

        return saTaskForExperts;

    }
}
