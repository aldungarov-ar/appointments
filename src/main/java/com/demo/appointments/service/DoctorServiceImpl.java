package com.demo.appointments.service;

import com.demo.appointments.entity.Doctor;
import com.demo.appointments.exception.DoctorNotFoundException;
import com.demo.appointments.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    /*@Override
    public boolean doctorExists(Long id) {
        return doctorRepository.findById(id).isPresent();
    }*/

    @Override
    public List<Doctor> getDoctorsBySpecializationName(String specializationName) {
        List<Doctor> doctors = doctorRepository.findBySpecialization_NameIgnoreCase(specializationName);
        return doctors.isEmpty() ? Collections.emptyList() : doctors;
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() ->
                new DoctorNotFoundException("Doctor with ID " + doctorId + " not found"));
    }
}
