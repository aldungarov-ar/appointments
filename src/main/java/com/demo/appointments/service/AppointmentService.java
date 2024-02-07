package com.demo.appointments.service;

import com.demo.appointments.entity.Appointment;

import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAppointmentsByShiftId(Long id);

    Appointment getAppointmentWithinPeriod(List<Appointment> existingAppointments,
                                           LocalTime appointmentStartTime, LocalTime appointmentEndTime);
}
