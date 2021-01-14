package com.sas.sasystem.entities;

public class GradeForExpert extends Grade{
    private Expert expert;
    private SATaskForExpert saTaskForExpert;

    public GradeForExpert(int grade, Expert expert, SATaskForExpert saTaskForExpert) {
        this.grade = grade;
        this.expert = expert;
        this.saTaskForExpert = saTaskForExpert;
    }

    public Expert getExpert() {
        return expert;
    }

    public SATaskForExpert getSaTaskForExpert() {
        return saTaskForExpert;
    }
}
