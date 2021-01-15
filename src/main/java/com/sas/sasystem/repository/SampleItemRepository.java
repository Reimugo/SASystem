package com.sas.sasystem.repository;

import com.sas.sasystem.entities.SampleItem;

import java.util.ArrayList;

public interface SampleItemRepository {
    SampleItem findItemById(int id);
}
