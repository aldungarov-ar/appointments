package com.demo.appointments.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    // duration in minutes
    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "first_time", nullable = false)
    private Boolean firstTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_appointment_doctor"))
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_appointment_patient"))
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_appointment_shift"))
    private Shift shift;
}
