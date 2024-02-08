package com.demo.appointments.dto;

import com.demo.appointments.entity.Patient;
import lombok.Data;

@Data
public class AssignRq {

    private Long slotId;
    private Long patientId;
}
