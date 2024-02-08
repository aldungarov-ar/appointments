package com.demo.appointments.service;

import com.demo.appointments.entity.Appointment;
import com.demo.appointments.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
