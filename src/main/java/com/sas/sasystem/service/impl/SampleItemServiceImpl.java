package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.SampleItem;
import com.sas.sasystem.entities.SampleTask;
import com.sas.sasystem.repository.SampleItemRepository;
import com.sas.sasystem.repository.impl.SampleItemRepositoryImpl;
import com.sas.sasystem.service.ISampleItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SampleItemServiceImpl implements ISampleItemService {
    private SampleItemRepository sampleItemRepository = new SampleItemRepositoryImpl();

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
