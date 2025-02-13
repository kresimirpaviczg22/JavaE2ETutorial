package com.eviden.e2e.util;

public class StringUtil {

    public static String nullIfEmpty(String str) {
        return str.isEmpty() ? null : str;
    }
}
