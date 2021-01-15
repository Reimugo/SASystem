package com.sas.sasystem.configuration;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.util.DateTimeUtils;

import java.util.ArrayList;

public class Constants {
    public User manager1;
    public User manager2;

    public Expert expert1;
    public Expert expert2;

    public Market market1;
    public Market market2;

    public Product product1;
    public Product product2;
    public Product product3;
    public Product product4;

    public ArrayList<SampleItem> unfinishedSampleItemsForMarket = new ArrayList<>();


    public ArrayList<GradeForExpert> gradeForExperts = new ArrayList<>();
    public ArrayList<GradeForMarket> gradeForMarkets = new ArrayList<>();

    public ArrayList<SampleItemReport> itemReports = new ArrayList<>();


    public ArrayList<SATaskForExpert> saTaskForExperts = new ArrayList<>();
    public ArrayList<SATaskForMarket> saTaskForMarkets = new ArrayList<>();


    private void createMarketSATasks(){
        SampleItem sampleItem1 = new SampleItem(product1);
        SampleItemReport sampleItemReport1 = new SampleItemReport(sampleItem1,3,DateTimeUtils.parse("2021-01-16"),"report1");
        itemReports.add(sampleItemReport1);
        sampleItemReport1.submit();
        SampleTask sampleTask1 = new SampleTask(market1);
        sampleTask1.addSampleItem(sampleItem1);

        SampleItem sampleItem2 = new SampleItem(product2);
        unfinishedSampleItemsForMarket.add(sampleItem2);
        SampleTask sampleTask2 = new SampleTask(market2);
        SampleItem sampleItem3 = new SampleItem(product3);
        unfinishedSampleItemsForMarket.add(sampleItem3);
        SampleItem sampleItem4 = new SampleItem(product4);
        unfinishedSampleItemsForMarket.add(sampleItem4);
        sampleTask2.addSampleItem(sampleItem2);
        sampleTask2.addSampleItem(sampleItem3);
        sampleTask2.addSampleItem(sampleItem4);

        SATaskForMarket saTaskForMarket1 = new SATaskForMarket("pj1",manager1,DateTimeUtils.parse("2021-01-31"),"OOAD-pj1");
        saTaskForMarket1.setFinished(true);
        saTaskForMarket1.setFinishDate(DateTimeUtils.parse("2021-01-16"));
        saTaskForMarket1.addSampleTask(sampleTask1);

        SATaskForMarket saTaskForMarket2 = new SATaskForMarket("pj2",manager2,DateTimeUtils.parse("2021-01-31"),"OOAD-pj2");
        saTaskForMarket2.addSampleTask(sampleTask2);

        saTaskForMarkets.add(saTaskForMarket1);
        saTaskForMarkets.add(saTaskForMarket2);
    }

    private void createExpertSATasks(){
        SampleItem sampleItem1 = new SampleItem(product1);
        SampleItemReport sampleItemReport2 = new SampleItemReport(sampleItem1,3,DateTimeUtils.parse("2021-01-16"),"report2");
        itemReports.add(sampleItemReport2);
        sampleItemReport2.submit();
        SampleTask sampleTask1 = new SampleTask(market1);
        sampleTask1.addSampleItem(sampleItem1);

        SampleItem sampleItem2 = new SampleItem(product2);
        SampleTask sampleTask2 = new SampleTask(market2);
        SampleItem sampleItem3 = new SampleItem(product3);
        SampleItem sampleItem4 = new SampleItem(product4);
        sampleTask2.addSampleItem(sampleItem2);
        sampleTask2.addSampleItem(sampleItem3);
        sampleTask2.addSampleItem(sampleItem4);

        SATaskForExpert saTaskForExpert1 = new SATaskForExpert("expertTask1",manager1,DateTimeUtils.parse("2021-01-31"),"expertTask1",expert1);
        saTaskForExpert1.setFinished(true);
        saTaskForExpert1.setFinishDate(DateTimeUtils.parse("2021-01-16"));
        saTaskForExpert1.addSampleTask(sampleTask1);

        SATaskForExpert saTaskForExpert2 = new SATaskForExpert("expertTask2",manager2,DateTimeUtils.parse("2021-01-31"),"expertTask2",expert2);
        saTaskForExpert2.addSampleTask(sampleTask2);

        saTaskForExperts.add(saTaskForExpert1);
        saTaskForExperts.add(saTaskForExpert2);
    }

    public Constants(User manager1, User manager2, Expert expert1, Expert expert2, Market market1, Market market2, Product product1, Product product2, Product product3, Product product4) {
        this.manager1 = manager1;
        this.manager2 = manager2;
        this.expert1 = expert1;
        this.expert2 = expert2;
        this.market1 = market1;
        this.market2 = market2;
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
        this.product4 = product4;

        this.createMarketSATasks();
        this.createExpertSATasks();
    }
}
