package com.demo.appointments.controller;

import com.demo.appointments.generated_soap_dto.shifts.ShiftRequest;
import com.demo.appointments.generated_soap_dto.shifts.ShiftResponse;
import com.demo.appointments.service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ShiftEndpoint {

    private final ShiftService shiftService;

    private static final String NAMESPACE_URI = "http://www.appointments.demo.com/generated_soap_dto/shifts";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "shiftRequest")
    @ResponsePayload
    public ShiftResponse generateShift(@RequestPayload ShiftRequest request) {
        return shiftService.createShift(request);
    }
}
