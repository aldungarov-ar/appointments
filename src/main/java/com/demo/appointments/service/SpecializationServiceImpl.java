package com.demo.appointments.service;

import com.demo.appointments.entity.Specialization;
import com.demo.appointments.exception.BadRequestException;
import com.demo.appointments.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;

    public boolean specializationExists(String name) {
        return specializationRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public int getAppointmentDuration(String name) {
        Specialization specialization = specializationRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new BadRequestException("Specialization " + name + " not found"));
        return specialization.getAppointmentDuration();
    }
}
