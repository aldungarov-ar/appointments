package com.demo.appointments.service;

import com.demo.appointments.entity.Shift;
import com.demo.appointments.generated_soap_dto.shifts.ShiftRequest;
import com.demo.appointments.generated_soap_dto.shifts.ShiftResponse;

import java.time.LocalDate;
import java.util.List;

public interface ShiftService {

    List<Shift> getDoctorShiftsInPeriod(Long doctorId, LocalDate startDate, LocalDate endDate);

    ShiftResponse createShift(ShiftRequest request);
}
