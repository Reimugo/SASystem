package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.IIndicatorService;
import com.sas.sasystem.util.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class IndicatorServiceImpl implements IIndicatorService {

    private ArrayList<SATaskForExpert> saTasks;

    private ArrayList<GradeForExpert> expertGrades;

   private ArrayList<SATaskForMarket> saTasksForMarket;

    private ArrayList<GradeForMarket> marketGrades;

    @Override
    public void update() {

        //更新对专家的评分
        for (SATaskForExpert saTask:saTasks
             ) {
            GradeForExpert grade = getSATaskGrade(saTask);
            GradeForExpert criterionGrade = getCriterionGradeForSATask(saTask);
            Expert expert = (Expert) saTask.getExpert();

            if(grade == null){
                if(criterionGrade != null){
                    expert.updateScore(criterionGrade);
                    expertGrades.add(criterionGrade);
                }
            }else {
                expertGrades.remove(grade);
                expert.updateScore(grade,criterionGrade);
                expertGrades.add(criterionGrade);
            }

        }

        //更新对农贸市场的评分
        for (SATaskForMarket saTask:saTasksForMarket
        ) {
            ArrayList<SampleTask> sampleTasks = saTask.getSampleTasks();

            for (SampleTask sampleTask:sampleTasks
            ) {
                GradeForMarket grade = getSampleTaskGrade(sampleTask);
                GradeForMarket criterionGrade = getCriterionGradeForMarket(saTask,sampleTask);
                Market market = sampleTask.getMarket();

                if(grade == null){
                    if(criterionGrade != null){
                        market.updateScore(criterionGrade);
                        marketGrades.add(criterionGrade);
                    }
                }else {
                    marketGrades.remove(grade);
                    market.updateScore(grade,criterionGrade);
                    marketGrades.add(criterionGrade);
                }
            }



        }


    }

    private GradeForExpert getSATaskGrade(SATask saTask) {
        for (GradeForExpert g: expertGrades
        ) {
            if(g.getSaTaskForExpert() == saTask){
                return g;
            }
        }
        return null;
    }

    private GradeForMarket getSampleTaskGrade(SampleTask sampleTask) {
        return null;
    }

    private GradeForExpert getCriterionGradeForSATask(SATaskForExpert saTask) {

        Date deadline = saTask.getDeadline();
        Date date;
        int differ;
        GradeForExpert grade;

        if(saTask.isFinished()){
            date = saTask.getFinishDate();
            differ = DateTimeUtils.getDayDiffer(deadline,date);
            if(differ <= 0 ){
                grade = new  GradeForExpert(10,"finish on time",saTask);
            }
        }else {
            //todo 得到系统时间
            date = new Date();
            differ = DateTimeUtils.getDayDiffer(deadline,date);
        }

        if(differ <= 20){
            grade = new GradeForExpert(-10,"not finish on time",saTask);
        }else {
            grade = new GradeForExpert(-30,"Late for more than 20 days",saTask);
        }

        return grade;
    }

    private GradeForMarket getCriterionGradeForMarket(SATaskForMarket saTask,SampleTask sampleTask) {

        Date deadline = saTask.getDeadline();
        Date date;
        int differ;
        GradeForMarket grade;

        if(saTask.isFinished()){
            date = sampleTask.getFinishDate();
            differ = DateTimeUtils.getDayDiffer(deadline,date);
            if(differ <= 0 ){
                grade = new  GradeForMarket(10,"finish on time",sampleTask);
            }
        }else {
            //todo 得到系统时间
            date = new Date();
            differ = DateTimeUtils.getDayDiffer(deadline,date);
        }

        if(differ <= 20){
            grade = new GradeForMarket(-10,"not finish on time",sampleTask);
        }else {
            grade = new GradeForMarket(-30,"Late for more than 20 days",sampleTask);
        }

        return grade;
    }

    public void setSaTasks(ArrayList<SATaskForExpert> saTasks) {
        this.saTasks = saTasks;
    }

    public void setExpertGrades(ArrayList<GradeForExpert> expertGrades) {
        this.expertGrades = expertGrades;
    }

    public void setSaTasksForMarket(ArrayList<SATaskForMarket> saTasksForMarket) {
        this.saTasksForMarket = saTasksForMarket;
    }

    public void setMarketGrades(ArrayList<GradeForMarket> marketGrades) {
        this.marketGrades = marketGrades;
    }
}
