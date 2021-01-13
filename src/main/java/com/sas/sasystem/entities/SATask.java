package com.sas.sasystem.entities;

import java.util.ArrayList;
import java.util.Date;

public class SATask {
    protected String name;
    protected ArrayList<SampleTask> sampleTasks;
    protected boolean isFinished;
    protected User manager;
    protected Date creationDate;
    protected Date deadline;
    protected Date releaseDate;
    protected Date finishDate;
    protected String description;

    public SATask(String name, User manager, Date deadline, String description) {
        this.name = name;
        this.manager = manager;
        this.sampleTasks = new ArrayList<>();
        this.creationDate = new Date();
        this.deadline = deadline;
        this.isFinished = false;
        this.finishDate = null;
        this.description = description;
    }

    public ArrayList<SampleTask> getSampleTasks() {
        return sampleTasks;
    }

    public String getName() {
        return name;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public User getManager() {
        return manager;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addSampleTask(SampleTask sampleTask) {
        sampleTasks.add(sampleTask);
    }
}
