//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.09 at 01:22:55 AM GET 
//


package com.demo.appointments.generated_soap_dto.shifts;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter3;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * <p>Java class for condition complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="condition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="doctor_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="start_date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="end_date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="time_start" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/&gt;
 *         &lt;element name="time_end" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "condition", propOrder = {
        "doctorId",
        "startDate",
        "endDate",
        "period",
        "timeStart",
        "timeEnd"
})
public class Condition {

    @XmlElement(name = "doctor_id")
    protected long doctorId;
    @XmlElement(name = "start_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3.class)
    @XmlSchemaType(name = "date")
    protected LocalDate startDate;
    @XmlElement(name = "end_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3.class)
    @XmlSchemaType(name = "date")
    protected LocalDate endDate;
    @XmlElement(required = true)
    protected String period;
    @XmlElementRef(name = "time_start", namespace = "http://www.appointments.demo.com/generated_soap_dto/shifts", type = JAXBElement.class, required = false)
    protected JAXBElement<LocalTime> timeStart;
    @XmlElementRef(name = "time_end", namespace = "http://www.appointments.demo.com/generated_soap_dto/shifts", type = JAXBElement.class, required = false)
    protected JAXBElement<LocalTime> timeEnd;

    /**
     * Gets the value of the doctorId property.
     */
    public long getDoctorId() {
        return doctorId;
    }

    /**
     * Sets the value of the doctorId property.
     */
    public void setDoctorId(long value) {
        this.doctorId = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStartDate(LocalDate value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEndDate(LocalDate value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the period property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPeriod(String value) {
        this.period = value;
    }

    /**
     * Gets the value of the timeStart property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link LocalTime }{@code >}
     */
    public JAXBElement<LocalTime> getTimeStart() {
        return timeStart;
    }

    /**
     * Sets the value of the timeStart property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link LocalTime }{@code >}
     */
    public void setTimeStart(JAXBElement<LocalTime> value) {
        this.timeStart = value;
    }

    /**
     * Gets the value of the timeEnd property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link LocalTime }{@code >}
     */
    public JAXBElement<LocalTime> getTimeEnd() {
        return timeEnd;
    }

    /**
     * Sets the value of the timeEnd property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link LocalTime }{@code >}
     */
    public void setTimeEnd(JAXBElement<LocalTime> value) {
        this.timeEnd = value;
    }

}
