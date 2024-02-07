//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.07 at 12:43:28 PM GET 
//


package com.demo.appointments.generated_soap_dto.schedule;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.demo.appointments.generated_soap_dto.schedule package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SlotPatientId_QNAME = new QName("http://www.appointments.demo.com/generated_soap_dto/schedule", "patient_id");
    private final static QName _RuleDoctorId_QNAME = new QName("http://www.appointments.demo.com/generated_soap_dto/schedule", "doctor_id");
    private final static QName _RuleAppointmentDuration_QNAME = new QName("http://www.appointments.demo.com/generated_soap_dto/schedule", "appointment_duration");
    private final static QName _RuleSlotsAmount_QNAME = new QName("http://www.appointments.demo.com/generated_soap_dto/schedule", "slots_amount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.appointments.generated_soap_dto.schedule
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ScheduleRequest }
     */
    public ScheduleRequest createScheduleRequest() {
        return new ScheduleRequest();
    }

    /**
     * Create an instance of {@link Rule }
     */
    public Rule createRule() {
        return new Rule();
    }

    /**
     * Create an instance of {@link ScheduleResponse }
     */
    public ScheduleResponse createScheduleResponse() {
        return new ScheduleResponse();
    }

    /**
     * Create an instance of {@link Slot }
     */
    public Slot createSlot() {
        return new Slot();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.appointments.demo.com/generated_soap_dto/schedule", name = "patient_id", scope = Slot.class)
    public JAXBElement<Long> createSlotPatientId(Long value) {
        return new JAXBElement<Long>(_SlotPatientId_QNAME, Long.class, Slot.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.appointments.demo.com/generated_soap_dto/schedule", name = "doctor_id", scope = Rule.class)
    public JAXBElement<Long> createRuleDoctorId(Long value) {
        return new JAXBElement<Long>(_RuleDoctorId_QNAME, Long.class, Rule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.appointments.demo.com/generated_soap_dto/schedule", name = "appointment_duration", scope = Rule.class)
    public JAXBElement<Integer> createRuleAppointmentDuration(Integer value) {
        return new JAXBElement<Integer>(_RuleAppointmentDuration_QNAME, Integer.class, Rule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.appointments.demo.com/generated_soap_dto/schedule", name = "slots_amount", scope = Rule.class)
    public JAXBElement<Integer> createRuleSlotsAmount(Integer value) {
        return new JAXBElement<Integer>(_RuleSlotsAmount_QNAME, Integer.class, Rule.class, value);
    }

}