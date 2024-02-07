package com.demo.appointments.service;

import com.demo.appointments.entity.Appointment;
import com.demo.appointments.entity.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAppointmentsByShiftId(Long id) {
        return appointmentRepository.findByShift_Id(id).isEmpty() ?
                Collections.emptyList() : appointmentRepository.findByShift_Id(id);
    }

    @Override
    public Appointment getAppointmentWithinPeriod(List<Appointment> existingAppointments,
                                                  LocalTime appointmentStartTime, LocalTime appointmentEndTime) {
        for (Appointment appointment : existingAppointments) {
            LocalTime existingAppointmentStartTime = appointment.getStartTime().toLocalTime();
            LocalTime existingAppointmentEndTime = appointment.getEndTime().toLocalTime();

            boolean newAppointmentStartTimeIsInExistingSlot =
                    appointmentStartTime.isAfter(existingAppointmentStartTime) &&
                            appointmentEndTime.isBefore(existingAppointmentEndTime);
            boolean newAppointmentEndTimeIsInExistingSlot =
                    appointmentEndTime.isAfter(existingAppointmentStartTime) &&
                            appointmentEndTime.isBefore(existingAppointmentEndTime);

            if (newAppointmentStartTimeIsInExistingSlot ||
                    newAppointmentEndTimeIsInExistingSlot) {
                return appointment;
            }
        }

        return null;
    }
}
