//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.09 at 06:22:23 AM GET 
//


package com.demo.appointments.generated_soap_dto.schedule;

import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;
import org.w3._2001.xmlschema.Adapter2;


/**
 * <p>Java class for slot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="slot"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="doctor_specialization" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="doctor_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="start_time" type="{http://www.w3.org/2001/XMLSchema}time"/&gt;
 *         &lt;element name="end_time" type="{http://www.w3.org/2001/XMLSchema}time"/&gt;
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="patient_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "slot", propOrder = {
    "id",
    "date",
    "doctorSpecialization",
    "doctorId",
    "startTime",
    "endTime",
    "duration",
    "patientId"
})
public class Slot {

    protected long id;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime date;
    @XmlElement(name = "doctor_specialization", required = true)
    protected String doctorSpecialization;
    @XmlElement(name = "doctor_id")
    protected long doctorId;
    @XmlElement(name = "start_time", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "time")
    protected LocalTime startTime;
    @XmlElement(name = "end_time", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "time")
    protected LocalTime endTime;
    protected int duration;
    @XmlElementRef(name = "patient_id", namespace = "http://www.appointments.demo.com/generated_soap_dto/schedule", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> patientId;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(LocalDateTime value) {
        this.date = value;
    }

    /**
     * Gets the value of the doctorSpecialization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    /**
     * Sets the value of the doctorSpecialization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorSpecialization(String value) {
        this.doctorSpecialization = value;
    }

    /**
     * Gets the value of the doctorId property.
     * 
     */
    public long getDoctorId() {
        return doctorId;
    }

    /**
     * Sets the value of the doctorId property.
     * 
     */
    public void setDoctorId(long value) {
        this.doctorId = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(LocalTime value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(LocalTime value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPatientId(JAXBElement<Long> value) {
        this.patientId = value;
    }

}
