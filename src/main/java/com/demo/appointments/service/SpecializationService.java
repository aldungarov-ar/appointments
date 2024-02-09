package com.demo.appointments.service;

public interface SpecializationService {
    boolean specializationExists(String name);

    int getAppointmentDuration(String name);
}
