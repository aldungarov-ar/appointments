package com.demo.appointments.mapper;

import java.time.LocalTime;

public class SOAPTimeAdapter {

    private SOAPTimeAdapter() {
    }

    public static LocalTime unmarshal(String v) {
        return LocalTime.parse(v);
    }

    public static String marshal(LocalTime v) {
        return v.toString();
    }
}
