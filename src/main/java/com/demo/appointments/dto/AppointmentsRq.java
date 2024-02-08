package com.demo.appointments.dto;

import lombok.Data;

@Data
public class AppointmentsRq {

        private String date;
        private Long doctorId;
        private String specialization;
}
