package com.demo.appointments.exception;

public class ConditionValidationException extends BadRequestException {
    public ConditionValidationException(String s) {
        super(s);
    }
}
