package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.ISampleTaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SampleTaskServiceImpl implements ISampleTaskService {

    @Override
    public ArrayList<SampleTask> findSampleTasks(SATask saTask, Market market) {
        ArrayList<SampleTask> sampleTasks = saTask.getSampleTasks();
        ArrayList<SampleTask> ret = new ArrayList<>();
        for (SampleTask sampleTask : sampleTasks
                ) {
            if(sampleTask.getMarket() == market){
                ret.add(sampleTask);
            }
        }
        return ret;
    }

    @Override
    public ArrayList<SampleTask> findUnfinishedSampleTasks(SATask saTask, Market market) {
        ArrayList<SampleTask> sampleTasks = saTask.getSampleTasks();
        ArrayList<SampleTask> ret = new ArrayList<>();
        for (SampleTask sampleTask : sampleTasks
        ) {
            if(sampleTask.getMarket() == market && (!sampleTask.isFinished())){
                ret.add(sampleTask);
            }
        }
        return ret;
    }

    @Override
    public ArrayList<SampleTask> findUnfinishedSampleTasks(SATask saTask) {
        ArrayList<SampleTask> sampleTasks = saTask.getSampleTasks();
        ArrayList<SampleTask> ret = new ArrayList<>();
        for (SampleTask sampleTask : sampleTasks
        ) {
            if(!sampleTask.isFinished()){
                ret.add(sampleTask);
            }
        }
        return ret;
    }
}
