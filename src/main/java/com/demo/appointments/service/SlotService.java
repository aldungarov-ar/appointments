package com.demo.appointments.service;

import com.demo.appointments.dto.AppointmentsRq;
import com.demo.appointments.dto.AssignRq;
import com.demo.appointments.dto.CommonRs;
import com.demo.appointments.dto.PatientAppointmentsRq;
import com.demo.appointments.entity.Appointment;
import com.demo.appointments.entity.Patient;
import com.demo.appointments.exception.BadRequestException;
import com.demo.appointments.repository.AppointmentRepository;
import com.demo.appointments.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public CommonRs<List<Appointment>> getSlotsByDateAndDoctor(AppointmentsRq appointmentsRq) {
        validateAppointmentsRq(appointmentsRq);

        List<Appointment> appointments = new ArrayList<>();
        if (appointmentsRq.getDoctorId() != null) {
            appointments.addAll(appointmentRepository.findByShift_DateAndDoctor_Id(
                    parseDate(appointmentsRq.getDate()),
                    appointmentsRq.getDoctorId()));

            if (appointments.isEmpty()) {
                throw new BadRequestException("No appointments found for the given date and doctor");
            }
        } else if (appointmentsRq.getSpecialization() != null) {
            appointments.addAll(appointmentRepository.findByShift_DateAndDoctor_Specialization_Name(
                    parseDate(appointmentsRq.getDate()),
                    appointmentsRq.getSpecialization()));

            if (appointments.isEmpty()) {
                throw new BadRequestException("No appointments found for the given specialization and date");
            }
        }

        CommonRs<List<Appointment>> response = new CommonRs<>();
        response.setData(appointments);

        return response;
    }

    private void validateAppointmentsRq(AppointmentsRq appointmentsRq) {
        if (appointmentsRq == null) {
            throw new BadRequestException("AppointmentsRq must not be null");
        }
        if (appointmentsRq.getDate() == null) {
            throw new BadRequestException("Date is required");
        }
        if (appointmentsRq.getDoctorId() == null && appointmentsRq.getSpecialization() == null) {
            throw new BadRequestException("DoctorId or Specialization is required");
        }
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public CommonRs<Appointment> assignSlot(AssignRq assignRq) {
        validateAssignRq(assignRq);

        Patient patient = patientRepository.findById(assignRq.getPatientId())
                .orElseThrow(() -> new BadRequestException(
                        "Patient with id: " + assignRq.getPatientId() + " not found"));

        Appointment appointment = appointmentRepository.findById(assignRq.getSlotId())
                .orElseThrow(() -> new BadRequestException(
                        "Appointment with id: " + assignRq.getSlotId() + " not found"));
        if (appointment.getPatient() != null) {
            throw new BadRequestException("Slot already occupied");
        }

        appointment.setPatient(patient);
        appointment.setPatientId(patient.getId());
        appointmentRepository.save(appointment);

        CommonRs<Appointment> response = new CommonRs<>();
        response.setData(appointment);

        return response;
    }

    private void validateAssignRq(AssignRq assignRq) {
        if (assignRq == null) {
            throw new BadRequestException("AssignRq must not be null");
        }
        if (assignRq.getSlotId() == null) {
            throw new BadRequestException("AppointmentId (SlotId) is required");
        }
        if (assignRq.getPatientId() == null) {
            throw new BadRequestException("PatientId or patient is required");
        }
    }

    public CommonRs<List<Appointment>> getSlotsByPatient(PatientAppointmentsRq appointmentsRq) {

        validatePatientAppointmentsRq(appointmentsRq);

        List<Appointment> appointments = new ArrayList<>();

        if (appointmentsRq.getPatientId() != null) {
            appointments = appointmentRepository.findByPatient_Id(appointmentsRq.getPatientId());
        } else if (appointmentsRq.getPatientUUID() != null) {
            appointments = appointmentRepository.findByPatient_Uuid(appointmentsRq.getPatientUUID());
        }

        if (appointmentsRq.getDate() != null) {
            appointments = appointments.stream().filter(appointment ->
                    appointment.getShift().getDate().equals(
                            LocalDate.parse(appointmentsRq.getDate()))).toList();
        }

        if (appointments.isEmpty()) {
            throw new BadRequestException("No appointments found for the given patient");
        }

        CommonRs<List<Appointment>> response = new CommonRs<>();
        response.setData(appointments);

        return response;
    }

    private void validatePatientAppointmentsRq(PatientAppointmentsRq appointmentsRq) {
        if (appointmentsRq == null) {
            throw new BadRequestException("PatientAppointmentsRq must not be null");
        }
        if (appointmentsRq.getPatientId() == null && appointmentsRq.getPatientUUID() == null) {
            throw new BadRequestException("PatientId or UUID is required");
        }
    }
}
