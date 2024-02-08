package com.demo.appointments.mapper;

import com.demo.appointments.entity.Shift;
import com.demo.appointments.generated_soap_dto.shifts.ShiftElement;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ObjectFactory.class)
public interface ShiftMapper {

    ShiftMapper INSTANCE = Mappers.getMapper(ShiftMapper.class);

    ShiftElement toShiftElement(Shift shift);
}
