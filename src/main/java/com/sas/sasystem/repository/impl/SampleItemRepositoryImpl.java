package com.sas.sasystem.repository.impl;

import com.sas.sasystem.entities.SampleItem;
import com.sas.sasystem.repository.SampleItemRepository;

import java.util.ArrayList;

public class SampleItemRepositoryImpl implements SampleItemRepository {

    private ArrayList<SampleItem> sampleItems;

    public SampleItemRepositoryImpl(ArrayList<SampleItem> sampleItems) {
        this.sampleItems = sampleItems;
    }

    @Override
    public SampleItem findItemById(int id) {
        for (SampleItem item: sampleItems
             ) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
