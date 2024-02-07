package com.demo.appointments.exception;

public class DoctorNotFoundException extends BadRequestException {
    public DoctorNotFoundException(String s) {
        super(s);
    }
}
