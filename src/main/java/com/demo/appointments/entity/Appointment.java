package com.demo.appointments.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    // duration in minutes
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "shift_id", nullable = false)
    private Long shiftId;

    @Column(name = "first_time")
    private Boolean firstTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_appointment_doctor"))
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_appointment_patient"))
    @JsonIgnore
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_appointment_shift"))
    @JsonIgnore
    private Shift shift;
}
