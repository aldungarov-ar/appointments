package com.demo.appointments.controller;

import com.demo.appointments.dto.*;
import com.demo.appointments.entity.Appointment;
import com.demo.appointments.service.SlotService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@RequiredArgsConstructor
@ApiResponse(responseCode = "400", description = "Bad request",
        content = @Content(schema = @Schema(implementation = ErrorRs.class)))
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
