package com.demo.appointments.repository;

import com.demo.appointments.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    @Query("select s from Shift s where s.doctorId = ?1 and s.date between ?2 and ?3")
    List<Shift> findByDoctorIdAndDateBetween(Long doctorId, LocalDate dateStart, LocalDate dateEnd);

    @Query("select s from Shift s where s.date between ?1 and ?2")
    List<Shift> findByDateBetween(Date dateStart, Date dateEnd);
}