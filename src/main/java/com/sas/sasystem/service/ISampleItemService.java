package com.sas.sasystem.service;

import com.sas.sasystem.entities.SampleItem;
import com.sas.sasystem.entities.SampleTask;

import java.util.ArrayList;

public interface ISampleItemService {
    ArrayList<SampleItem> findUnfinishedSampleItems(SampleTask sampleTask);

    SampleItem findSampleItem(int id);
}
