package com.sas.sasystem.Entity;

import java.util.ArrayList;

public class SATask {
    private ArrayList<SampleTask> sampleTasks;
    private boolean isComplete;
    private User manager;

    public SATask(User manager) {
        this.manager = manager;
    }
}
