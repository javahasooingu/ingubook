package com.ingubook.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class DateUtil {

    public static final String PATTERN = "yyyy년 MM월 dd일 HH:mm:ss";

    public static String getTimeToPattern(LocalDateTime time){

        return time.format(DateTimeFormatter.ofPattern(PATTERN));
    }

}
