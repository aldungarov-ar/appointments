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

    @Mapping(target = "date", source = "appointment.startTime")
    @Mapping(target = "doctorSpecialization",
            source = "appointment.doctor.specialization.name")
    Slot toSlot(Appointment appointment);


    // TODO: check if the following methods are needed
    /*default JAXBElement<Long> map(Long value) {
        QName qName = new QName(
                "http://www.appointments.demo.com/generated_soap_dto/schedule", "patient_id");
        return new JAXBElement<>(qName, Long.class, value);
    }*/

    /*default XMLGregorianCalendar map(Date value) {
        XMLGregorianCalendar xmlGregorianCalendar;
        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(value.toString());
        } catch (DatatypeConfigurationException e) {
            throw new SOAPMappingException("Failed to convert Date to XMLGregorianCalendar");
        }

        return xmlGregorianCalendar;
    }*/
}
