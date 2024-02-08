package com.demo.appointments.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ErrorRs {

    private String errorMessage;
    private Timestamp timestamp;

    public ErrorRs() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    public ErrorRs(Exception exception) {
        this.errorMessage = exception.getMessage();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
