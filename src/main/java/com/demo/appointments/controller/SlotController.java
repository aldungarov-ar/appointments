package com.demo.appointments.controller;

import com.demo.appointments.dto.AppointmentsRq;
import com.demo.appointments.dto.AssignRq;
import com.demo.appointments.dto.CommonRs;
import com.demo.appointments.dto.PatientAppointmentsRq;
import com.demo.appointments.entity.Appointment;
import com.demo.appointments.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@RequiredArgsConstructor
public class SlotController {

    private final SlotService slotService;

    @GetMapping("/findByDateAndDoctor")
    public CommonRs<List<Appointment>> getSlotsByDateAndDoctor(
            @RequestBody AppointmentsRq appointmentsRq) {
        return slotService.getSlotsByDateAndDoctor(appointmentsRq);
    }

    @GetMapping("/findByPatient")
    public CommonRs<List<Appointment>> getSlotsByPatient(
            @RequestBody PatientAppointmentsRq appointmentsRq) {
        return slotService.getSlotsByPatient(appointmentsRq);
    }

    @PutMapping("/assign")
    public CommonRs<Appointment> assignSlot(
            @RequestBody AssignRq assignRq) {
        return slotService.assignSlot(assignRq);
    }
}
