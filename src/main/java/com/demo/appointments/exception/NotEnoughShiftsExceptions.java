package com.demo.appointments.exception;

public class NotEnoughShiftsExceptions extends BadRequestException {
    public NotEnoughShiftsExceptions(String s) {
        super(s);
    }
}
