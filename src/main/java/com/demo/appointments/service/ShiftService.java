package com.demo.appointments.service;

import com.demo.appointments.entity.Shift;

import java.time.LocalDate;
import java.util.List;

public interface ShiftService {

    List<Shift> getDoctorShiftsInPeriod(Long doctorId, LocalDate startDate, LocalDate endDate);
}
