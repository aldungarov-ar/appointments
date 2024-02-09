package com.demo.appointments.mapper;

import com.demo.appointments.entity.Appointment;
import com.demo.appointments.generated_soap_dto.schedule.ObjectFactory;
import com.demo.appointments.generated_soap_dto.schedule.Slot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ObjectFactory.class)
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Mapping(target = "date", source = "appointment.shift.date")
    @Mapping(target = "doctorSpecialization",
            source = "appointment.doctor.specialization.name")
    Slot toSlot(Appointment appointment);
}
