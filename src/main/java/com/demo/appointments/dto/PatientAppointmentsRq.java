package com.demo.appointments.dto;

import lombok.Data;

@Data
public class PatientAppointmentsRq {

    private Long patientId;
    private Long patientUUID;
    private String date;
}
