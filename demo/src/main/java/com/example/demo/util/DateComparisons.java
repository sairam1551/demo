package com.example.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateComparisons {

    private DateComparisons(){}

    public static LocalDate getLocalesDate(){
        return LocalDate.now();
    }

    public static LocalDateTime getLocalesTimestamp(){
        return LocalDateTime.now();
    }

}
