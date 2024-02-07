package com.demo.appointments.service;

import com.demo.appointments.entity.Shift;
import com.demo.appointments.exception.DoctorNotFoundException;
import com.demo.appointments.exception.ShiftSearchException;
import com.demo.appointments.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;

    /*@Override
    public List<Shift> getShiftsInPeriod(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new ShiftSearchException("Start date and end date must be provided");
        }
        if (startDate.isAfter(endDate)) {
            throw new ShiftSearchException("Start date must be before end date");
        }

        List<Shift> shifts = shiftRepository.findByDateBetween(Date.valueOf(startDate), Date.valueOf(endDate));

        return (shifts == null || shifts.isEmpty()) ? Collections.emptyList() : shifts;
    }*/

    @Override
    public List<Shift> getDoctorShiftsInPeriod(Long doctorId, LocalDate startDate, LocalDate endDate) {
        if (doctorId == null || doctorId < 0) {
            throw new DoctorNotFoundException("Doctor ID must be a positive number");
        }
        if (startDate == null || endDate == null) {
            throw new ShiftSearchException("Start date and end date must be provided");
        }
        if (startDate.isAfter(endDate)) {
            throw new ShiftSearchException("Start date must be before end date");
        }

        List<Shift> shifts = shiftRepository.findByDoctorIdAndDateBetween(doctorId, startDate, endDate);
        return (shifts == null || shifts.isEmpty()) ? Collections.emptyList() : shifts;
    }
}
