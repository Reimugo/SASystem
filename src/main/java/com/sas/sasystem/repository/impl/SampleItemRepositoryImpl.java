package com.sas.sasystem.repository.impl;

import com.sas.sasystem.entities.SampleItem;
import com.sas.sasystem.repository.SampleItemRepository;

import java.util.ArrayList;

public class SampleItemRepositoryImpl implements SampleItemRepository {

    //todo 得到Item的list
    private ArrayList<SampleItem> sampleItems = new ArrayList<>();

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
