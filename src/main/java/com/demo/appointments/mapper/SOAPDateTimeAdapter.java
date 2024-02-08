package com.demo.appointments.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SOAPDateTimeAdapter {

    private SOAPDateTimeAdapter() {
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static LocalDateTime unmarshal(String v) {
        return LocalDateTime.parse(v, formatter);
    }

    public static String marshal(LocalDateTime v) {
        return v.format(formatter);
    }
}
