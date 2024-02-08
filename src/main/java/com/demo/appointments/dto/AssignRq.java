package com.demo.appointments.dto;

import lombok.Data;

@Data
public class AssignRq {

    private Long slotId;
    private Long patientId;
}
