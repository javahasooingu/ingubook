package com.ingubook.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    static final String PATTERN = "yyyy년 MM월 dd일 HH:mm:ss";

    public static String getTimeToPattern(LocalDateTime time){

        return time.format(DateTimeFormatter.ofPattern(PATTERN));
    }



}
