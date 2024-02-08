package com.demo.appointments.exception;

public class PredefinedShiftTimeParseException extends RuntimeException {
    public PredefinedShiftTimeParseException(String errorParsingPredefinedShiftTime) {
        super(errorParsingPredefinedShiftTime);
    }
}
