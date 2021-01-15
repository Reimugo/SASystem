package com.sas.sasystem.entities;

import java.util.Date;

public class GradeForExpert extends Grade{
    private Expert expert;
    private SATaskForExpert saTaskForExpert;

    public GradeForExpert(int num, String description, Expert expert, SATaskForExpert saTaskForExpert) {
        super(num, description);
        this.date = new Date();
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
