package com.demo.appointments.repository;

import com.demo.appointments.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select a from Appointment a where a.shift.id = ?1")
    List<Appointment> findByShift_Id(Long id);

    @Transactional
    @Modifying
    @Query("delete from Appointment a where a.shiftId = ?1")
    int deleteByShiftId(Long shiftId);
}