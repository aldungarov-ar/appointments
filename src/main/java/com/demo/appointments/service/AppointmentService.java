package com.demo.appointments.service;

import com.demo.appointments.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAppointmentsByShiftId(Long id);
}
