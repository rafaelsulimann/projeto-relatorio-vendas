package com.xbrain.projetoxbrain.controllers.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class URL {

    public static LocalDateTime converterMinDate(String textDate, LocalDateTime defaultValue){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC"));
        if(textDate != null){
        return LocalDate.parse(textDate, formatter).atTime(0, 0);
        }
        else{
            return defaultValue;
        }
    }

    public static LocalDateTime converterMaxDate(String textDate, LocalDateTime defaultValue){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC"));
        if(textDate != null){
        return LocalDate.parse(textDate, formatter).atTime(23, 59);
        }
        else{
            return defaultValue;
        }
    }
}
