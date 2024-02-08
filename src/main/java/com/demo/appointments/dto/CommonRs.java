package com.demo.appointments.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommonRs<T> {

    private T data;
    private Timestamp timestamp;
}
