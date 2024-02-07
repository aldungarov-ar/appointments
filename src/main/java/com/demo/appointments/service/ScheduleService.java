package com.demo.appointments.service;

import com.demo.appointments.generated_soap_dto.schedule.ScheduleRequest;
import com.demo.appointments.generated_soap_dto.schedule.ScheduleResponse;

public interface ScheduleService {
    ScheduleResponse generateSchedule(ScheduleRequest request);
}
