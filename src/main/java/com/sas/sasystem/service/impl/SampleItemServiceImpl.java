package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.SampleItem;
import com.sas.sasystem.entities.SampleTask;
import com.sas.sasystem.repository.SampleItemRepository;
import com.sas.sasystem.service.ISampleItemService;

import java.util.ArrayList;

public class SampleItemServiceImpl implements ISampleItemService {
    public SampleItemServiceImpl(SampleItemRepository sampleItemRepository) {
        this.sampleItemRepository = sampleItemRepository;
    }

    private SampleItemRepository sampleItemRepository;

    @Override
    public ArrayList<SampleItem> findUnfinishedSampleItems(SampleTask sampleTask) {
        ArrayList<SampleItem> sampleItems = sampleTask.getSampleItems();
        ArrayList<SampleItem> ret = new ArrayList<>();
        for (SampleItem item: sampleItems
             ) {
            if(!item.isFinished()){
                ret.add(item);
            }
        }
        return ret;
    }

    @Override
    public SampleItem findSampleItem(int id) {
        return sampleItemRepository.findItemById(id);
    }
}
