package com.demo.appointments.service;

import com.demo.appointments.entity.Appointment;
import com.demo.appointments.entity.Doctor;
import com.demo.appointments.entity.Shift;
import com.demo.appointments.exception.BadRequestException;
import com.demo.appointments.exception.DoctorNotFoundException;
import com.demo.appointments.exception.NotEnoughShiftsExceptions;
import com.demo.appointments.exception.ScheduleDatesException;
import com.demo.appointments.generated_soap_dto.schedule.Rule;
import com.demo.appointments.generated_soap_dto.schedule.ScheduleRequest;
import com.demo.appointments.generated_soap_dto.schedule.ScheduleResponse;
import com.demo.appointments.generated_soap_dto.schedule.Slot;
import com.demo.appointments.mapper.AppointmentMapper;
import com.demo.appointments.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final AppointmentRepository appointmentRepository;
    private final SpecializationService specializationService;
    private final DoctorService doctorService;
    private final ShiftService shiftService;
    private final AppointmentService appointmentService;

    @Value("${schedule.minimal-appointment-duration-minutes}")
    private Integer minimalAppointmentDuration;
    private static final AppointmentMapper APPOINTMENT_MAPPER = AppointmentMapper.INSTANCE;

    public ScheduleResponse generateSchedule(ScheduleRequest request) {
        Rule rule = request.getRule();
        validateRule(rule);

        LocalDateTime startDate = rule.getStartDate();
        LocalDateTime endDate = rule.getEndDate();
        String doctorSpecialization = rule.getDoctorSpecialization();
        Integer appointmentDuration = calculateAppointmentDuration(rule.getAppointmentDuration().getValue(), doctorSpecialization);
        Integer slotsAmount = rule.getSlotsAmount().getValue();
        long doctorId = rule.getDoctorId() != null ? rule.getDoctorId().getValue() : -1L;

        List<LocalDateTime> workingDates = getWorkingDays(startDate, endDate);
        if (workingDates.isEmpty()) {
            throw new ScheduleDatesException("No available working days for the given period");
        }

        List<Doctor> doctorsWithSpecialization = doctorId < 0 ? doctorService.getDoctorsBySpecializationName(doctorSpecialization) : List.of(doctorService.getDoctorById(doctorId));
        if (doctorsWithSpecialization == null || doctorsWithSpecialization.isEmpty()) {
            throw new DoctorNotFoundException("No doctors with " + doctorSpecialization + " specialization found");
        }

        List<Shift> availableShifts = findDoctorsShiftsInPeriod(doctorsWithSpecialization, startDate, endDate);
        if (availableShifts.isEmpty()) {
            throw new ScheduleDatesException("No available shifts for the given period");
        }

        List<Appointment> createdAppointments = new ArrayList<>();
        for (Shift shift : availableShifts) {
            List<Appointment> shiftAppointments = createAppointmentsForShift(shift, appointmentDuration, slotsAmount);
            createdAppointments.addAll(shiftAppointments);

            if (createdAppointments.size() >= slotsAmount) {
                break;
            }
            slotsAmount--;
        }
        if (createdAppointments.size() < slotsAmount) {
            throw new NotEnoughShiftsExceptions("Not enough shifts to generate the required amount of slots");
        }

        List<Slot> slots = convertAppointmentsToSlots(createdAppointments);
        ScheduleResponse scheduleResponse = new ScheduleResponse();
        scheduleResponse.getSlots().addAll(slots);

        return scheduleResponse;
    }

    private void validateRule(Rule rule) {
        if (rule == null) {
            throw new BadRequestException("Rule must be provided");
        }

        StringBuilder missingFields = new StringBuilder();
        if (rule.getStartDate() == null || rule.getEndDate() == null) {
            missingFields.append("Start and end dates must be provided").append("\n");
        }
        if (rule.getStartDate().isAfter(rule.getEndDate())) {
            missingFields.append("Start date must be before end date").append("\n");
        }
        if (rule.getDoctorSpecialization() == null || rule.getDoctorSpecialization().isEmpty()) {
            missingFields.append("Required specialization must be provided").append("\n");
        } else if (!specializationService.specializationExists(rule.getDoctorSpecialization())) {
            missingFields.append("No such specialization found. Please check the specialization name").append("\n");
        }
        if (rule.getDoctorId() != null && rule.getDoctorId().getValue() < 0) {
            missingFields.append("Doctor id must be a positive number").append("\n");
        } else {
            Doctor doctor = doctorService.getDoctorById(rule.getDoctorId().getValue());
            if (!doctor.getSpecialization().getName().equalsIgnoreCase(rule.getDoctorSpecialization())) {
                missingFields.append("Doctor with id ").append(rule.getDoctorId().getValue()).append(" does not have ").append(rule.getDoctorSpecialization()).append(" specialization").append("\n");
            }
        }
        if (rule.getSlotsAmount() == null || rule.getSlotsAmount().getValue() <= 0) {
            missingFields.append("Slots amount must be a positive number").append("\n");
        }

        if (!missingFields.isEmpty()) {
            throw new BadRequestException(missingFields.toString());
        }
    }

    private Integer calculateAppointmentDuration(int appointmentDuration, String doctorSpecialization) {
        if (appointmentDuration <= 0) {
            return specializationService.getAppointmentDuration(doctorSpecialization);
        } else if (appointmentDuration < minimalAppointmentDuration) {
            return minimalAppointmentDuration;
        }

        return appointmentDuration;
    }

    private List<LocalDateTime> getWorkingDays(LocalDateTime startDate, LocalDateTime endDate) {
        List<LocalDateTime> dates = new ArrayList<>();

        for (LocalDateTime date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            if (!isHoliday(date)) {
                dates.add(date);
            }
        }

        return dates;
    }

    private List<Shift> findDoctorsShiftsInPeriod(List<Doctor> doctors, LocalDateTime startDate, LocalDateTime endDate) {
        if (doctors == null || doctors.isEmpty()) {
            throw new DoctorNotFoundException("No doctors provided");
        }

        List<Shift> availableShifts = new ArrayList<>();

        for (Doctor doctor : doctors) {
            List<Shift> doctorShiftsInPeriod = shiftService.getDoctorShiftsInPeriod(
                    doctor.getId(), startDate.toLocalDate(), endDate.toLocalDate());
            availableShifts.addAll(doctorShiftsInPeriod);
        }
        return availableShifts;
    }

    private List<Appointment> createAppointmentsForShift(
            Shift shift, Integer appointmentDuration, Integer slotsAmount) {
        LocalTime shiftTimeStart = shift.getStartTime();
        LocalTime shiftTimeEnd = shift.getEndTime();

        List<Appointment> existingAppointments = appointmentService.getAppointmentsByShiftId(shift.getId());

        List<Appointment> appointmentsForShift = new ArrayList<>();
        LocalTime appointmentStartTime = shiftTimeStart;
        LocalTime appointmentEndTime = appointmentStartTime.plusMinutes(appointmentDuration);

        while (appointmentEndTime.isBefore(shiftTimeEnd) && slotsAmount-- > 0) {
            removeExistingAppointmentsWithinPeriod(existingAppointments, appointmentStartTime, appointmentEndTime);

            Appointment appointment = Appointment.builder()
                    .doctorId(shift.getDoctorId())
                    .startTime(appointmentStartTime)
                    .endTime(appointmentEndTime)
                    .duration(appointmentDuration)
                    .shift(shift)
                    .shiftId(shift.getId())
                    .firstTime(true)
                    .build();

            appointmentRepository.save(appointment);
            appointmentsForShift.add(appointment);

            appointmentStartTime = appointmentStartTime.plusMinutes(appointmentDuration);
            appointmentEndTime = appointmentStartTime.plusMinutes(appointmentDuration);
        }

        return appointmentsForShift;
    }

    private void removeExistingAppointmentsWithinPeriod(
            List<Appointment> existingAppointments, LocalTime appointmentStartTime, LocalTime appointmentEndTime) {

        List<Appointment> appointmentsToRemove = new ArrayList<>();
        for (Appointment existingAppointment : existingAppointments) {
            boolean appointmentTimeEquals = existingAppointment.getStartTime().equals(appointmentStartTime) ||
                    existingAppointment.getEndTime().equals(appointmentEndTime);
            boolean appointmentStartOverlap = existingAppointment.getStartTime().isAfter(appointmentStartTime) &&
                    existingAppointment.getStartTime().isBefore(appointmentEndTime);
            boolean appointmentEndOverlap = existingAppointment.getEndTime().isBefore(appointmentEndTime) &&
                    existingAppointment.getEndTime().isAfter(appointmentStartTime);
            boolean appointmentInside = existingAppointment.getStartTime().isBefore(appointmentStartTime) &&
                    existingAppointment.getEndTime().isAfter(appointmentEndTime);

            if (appointmentTimeEquals || appointmentStartOverlap || appointmentEndOverlap || appointmentInside) {
                appointmentRepository.delete(existingAppointment);
                appointmentsToRemove.add(existingAppointment);
            }
        }

        existingAppointments.removeAll(appointmentsToRemove);
    }

    private List<Slot> convertAppointmentsToSlots(List<Appointment> createdAppointments) {
        List<Slot> slots = new ArrayList<>();
        for (Appointment appointment : createdAppointments) {
            slots.add(APPOINTMENT_MAPPER.toSlot(appointment));
        }
        return slots;
    }

    private boolean isHoliday(LocalDateTime date) {
        return date.getDayOfWeek().getValue() > 5;
    }
}
