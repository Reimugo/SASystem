package com.sas.sasystem.service.impl;

import com.sas.sasystem.entities.*;
import com.sas.sasystem.service.IIndicatorService;
import com.sas.sasystem.util.DateTimeUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndicatorServiceImpl implements IIndicatorService {

    //todo 得到所有的SATaskForExpert
    ArrayList<SATaskForExpert> saTasks = new ArrayList<>();

    //todo 得到所有的专家得分
    ArrayList<GradeForExpert> expertGrades = new ArrayList<>();

    @Override
    public void update() {




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

        //todo 得到所有的SATaskForMarket
        ArrayList<SATaskForMarket> saTasksForMarket= new ArrayList<>();

        //todo 得到所有的农贸市场得分
        ArrayList<GradeForMarket> marketGrades = new ArrayList<>();

        ArrayList<SampleTask> sampleTasks= new ArrayList<>();
        for (SampleTask sampleTask:sampleTasks
        ) {
            if(sampleTask.isFinished() == false){

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

    private Grade getSampleTaskGrade(SampleTask sampleTask) {
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
}
