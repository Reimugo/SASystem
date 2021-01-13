package com.sas.sasystem.service;

import com.sas.sasystem.entities.Market;
import com.sas.sasystem.entities.SATask;
import com.sas.sasystem.entities.SampleTask;

import java.util.ArrayList;

public interface ISampleTaskService {
    ArrayList<SampleTask> findSampleTasks(SATask saTask, Market market);

    ArrayList<SampleTask> findUnfinishedSampleTasks(SATask saTask, Market market);

    ArrayList<SampleTask> findUnfinishedSampleTasks(SATask saTask);
}
