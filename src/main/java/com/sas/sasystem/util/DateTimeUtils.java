package com.sas.sasystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parse(String date) {
        if(date == null) {
            return null;
        }
        try {
            return FORMATTER.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getDayDiffer(Date startDate, Date endDate){
        try {
            long startDateTime = FORMATTER.parse(FORMATTER.format(startDate)).getTime();
            long endDateTime = FORMATTER.parse(FORMATTER.format(endDate)).getTime();
            return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
        }catch (ParseException e){
            e.printStackTrace();
        }

        return 0;
    }
}
