package com.demo.appointments.repository;

import com.demo.appointments.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Override
    boolean existsById(Long aLong);

    @Query("select p from Patient p where p.uuid = ?1")
    List<Patient> findByUuid(UUID uuid);
}