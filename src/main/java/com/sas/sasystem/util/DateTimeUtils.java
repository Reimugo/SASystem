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
}
