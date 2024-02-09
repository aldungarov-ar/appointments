package com.demo.appointments.repository;

import com.demo.appointments.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select a from Appointment a where a.shift.id = ?1")
    List<Appointment> findByShift_Id(Long id);

    @Transactional
    @Modifying
    @Query("delete from Appointment a where a.shiftId = ?1")
    void deleteByShiftId(Long shiftId);

    @Query("select a from Appointment a where a.shift.date = ?1 and a.doctor.id = ?2")
    List<Appointment> findByShift_DateAndDoctor_Id(LocalDate date, Long id);

    @Query("select a from Appointment a where a.shift.date = ?1 and a.doctor.specialization.name = ?2")
    List<Appointment> findByShift_DateAndDoctor_Specialization_Name(LocalDate date, String name);

    @Query("select a from Appointment a where a.patient.uuid = ?1")
    List<Appointment> findByPatient_Uuid(Long uuid);

    @Query("select a from Appointment a where a.patient.id = ?1")
    List<Appointment> findByPatient_Id(Long id);
}