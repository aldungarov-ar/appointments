package com.demo.appointments.service;

import com.demo.appointments.entity.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getDoctorsBySpecializationName(String specialization);

    Doctor getDoctorById(Long doctorId);
}
