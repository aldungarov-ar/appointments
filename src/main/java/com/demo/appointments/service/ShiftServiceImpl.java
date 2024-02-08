package com.demo.appointments.service;

import com.demo.appointments.configuration.ShiftPeriod;
import com.demo.appointments.entity.Shift;
import com.demo.appointments.exception.ConditionValidationException;
import com.demo.appointments.exception.DoctorNotFoundException;
import com.demo.appointments.exception.ShiftSearchException;
import com.demo.appointments.generated_soap_dto.shifts.Condition;
import com.demo.appointments.generated_soap_dto.shifts.ShiftElement;
import com.demo.appointments.generated_soap_dto.shifts.ShiftRequest;
import com.demo.appointments.generated_soap_dto.shifts.ShiftResponse;
import com.demo.appointments.mapper.ShiftMapper;
import com.demo.appointments.repository.AppointmentRepository;
import com.demo.appointments.repository.ShiftRepository;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;
    private final ShiftPeriod shiftPeriod;
    private static final ShiftMapper shiftMapperInstance = ShiftMapper.INSTANCE;
    private final AppointmentRepository appointmentRepository;


    @Override
    public ShiftResponse createShift(ShiftRequest request) {
        Condition condition = request.getCondition();
        validateCondition(condition);
        setPeriodIfPossible(condition);

        long doctorId = condition.getDoctorId();
        LocalDate dateFrom = condition.getStartDate();
        LocalDate dateTo = condition.getEndDate();
        String period = condition.getPeriod() == null ? "" :
                condition.getPeriod();
        LocalTime shiftStartTime = condition.getTimeStart() == null ?
                null : condition.getTimeStart().getValue();
        LocalTime shiftEndTime = condition.getTimeEnd().getValue();

        if (shiftStartTime == null && !period.isEmpty()) {
            shiftStartTime = shiftPeriod.getShiftStartTime(period);
            shiftEndTime = shiftPeriod.getShiftEndTime(period);
        }

        ShiftResponse shiftResponse = new ShiftResponse();

        if (shiftStartTime != null && shiftEndTime != null) {

            do {
                deleteExistingOverlappingShiftsIfExists(doctorId, dateFrom, shiftStartTime, shiftEndTime);

                Shift shift = Shift.builder()
                        .doctorId(doctorId)
                        .date(LocalDate.from(dateFrom))
                        .period(period)
                        .startTime(shiftStartTime)
                        .endTime(shiftEndTime)
                        .build();

                shiftRepository.save(shift);

                ShiftElement shiftElement = shiftMapperInstance.toShiftElement(shift);
                shiftResponse.getShifts().add(shiftElement);

                dateFrom = dateFrom.plusDays(1);
            } while (dateFrom.isBefore(dateTo) || dateFrom.equals(dateTo));
        }

        return shiftResponse;
    }

    private void setPeriodIfPossible(Condition condition) {
        if (condition.getPeriod() == null && condition.getTimeStart() != null &&
                condition.getTimeEnd() != null) {
            LocalTime timeStart = condition.getTimeStart().getValue();
            LocalTime timeEnd = condition.getTimeEnd().getValue();

            String period = shiftPeriod.getPeriodIfPossible(timeStart, timeEnd);
            condition.setPeriod(period);

        } else if (condition.getPeriod() != null && condition.getTimeStart() == null &&
                condition.getTimeEnd() == null) {

            LocalTime shiftStartTime = shiftPeriod.getShiftStartTime(condition.getPeriod());
            LocalTime shiftEndTime = shiftPeriod.getShiftEndTime(condition.getPeriod());

            condition.setTimeStart(new JAXBElement<>(
                    condition.getTimeStart().getName(),
                    LocalTime.class,
                    shiftStartTime));
            condition.setTimeEnd(new JAXBElement<>(
                    condition.getTimeEnd().getName(),
                    LocalTime.class,
                    shiftEndTime));
        }
    }

    private void deleteExistingOverlappingShiftsIfExists(
            long doctorId, LocalDate dateFrom, LocalTime newShiftStartTime, LocalTime newShiftEndTime) {
        List<Shift> existingDoctorsShifts =
                shiftRepository.findByDoctorIdAndDate(doctorId, dateFrom);

        for (Shift existingShift : existingDoctorsShifts) {
            LocalTime existingShiftStartTime = existingShift.getStartTime();
            LocalTime existingShiftEndTime = existingShift.getEndTime();

            boolean shiftTimeEquals = newShiftStartTime.equals(existingShiftStartTime) ||
                    newShiftEndTime.equals(existingShiftEndTime);
            boolean shiftStartOverlap = newShiftStartTime.isAfter(existingShiftStartTime) &&
                    newShiftStartTime.isBefore(existingShiftEndTime);
            boolean shiftEndOverlap = newShiftEndTime.isBefore(existingShiftEndTime) &&
                    newShiftEndTime.isAfter(existingShiftStartTime);
            boolean shiftInside = newShiftStartTime.isBefore(existingShiftStartTime) &&
                    newShiftEndTime.isAfter(existingShiftEndTime);

            if (shiftTimeEquals || shiftStartOverlap || shiftEndOverlap || shiftInside) {
                appointmentRepository.deleteByShiftId(existingShift.getId());
                shiftRepository.delete(existingShift);
            }
        }
    }

    private void validateCondition(Condition condition) {

        StringBuilder errorMessage = new StringBuilder();

        if (condition == null) {
            errorMessage.append("Condition must be provided");
        } else {
            if (condition.getDoctorId() < 0) {
                errorMessage.append("Doctor ID must be a positive number");
            }
            if (condition.getStartDate() == null || condition.getEndDate() == null) {
                errorMessage.append("Start date and end date must be provided");
            } else if (condition.getStartDate().isAfter(condition.getEndDate())) {
                errorMessage.append("Start date must be before end date");
            }
            if (condition.getPeriod() == null &&
                    (condition.getTimeStart() == null || condition.getTimeEnd() == null)) {
                errorMessage.append("Period or shift start and end time must be provided");
            }
        }

        if (!errorMessage.isEmpty()) {
            throw new ConditionValidationException(errorMessage.toString());
        }
    }

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

        List<Shift> shifts = shiftRepository.findByDoctorIdAndDateBetween(
                doctorId, startDate, endDate);
        return (shifts == null || shifts.isEmpty()) ? Collections.emptyList() : shifts;
    }
}
