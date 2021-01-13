package com.sas.sasystem.util;

public class StringArrayUtils {
    private static final char SPLIT_CHAR = '/';

    public static String[] parse(String s) {
        return s.split(String.valueOf(SPLIT_CHAR));
    }
}
