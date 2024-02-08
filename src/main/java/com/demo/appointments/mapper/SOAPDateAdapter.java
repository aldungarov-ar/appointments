package com.demo.appointments.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SOAPDateAdapter {

    private SOAPDateAdapter() {
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    public static LocalDate unmarshal(String v) {
        return LocalDate.parse(v, formatter);
    }

    public static String marshal(LocalDate v) {
        return v.format(formatter);
    }
}
