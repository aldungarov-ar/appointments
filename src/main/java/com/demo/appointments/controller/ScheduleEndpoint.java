package com.demo.appointments.controller;

import com.demo.appointments.generated_soap_dto.schedule.ScheduleRequest;
import com.demo.appointments.generated_soap_dto.schedule.ScheduleResponse;
import com.demo.appointments.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ScheduleEndpoint {

    private ScheduleService scheduleService;

    //TODO check URI
    private static final String NAMESPACE_URI = "com.demo.appointments.generated_soap_dto";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "schedule.ScheduleRequest")
    @ResponsePayload
    public ScheduleResponse generateSchedule(@RequestPayload ScheduleRequest request) {
        return scheduleService.generateSchedule(request);
    }
}
