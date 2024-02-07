//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.07 at 12:43:28 PM GET 
//


package com.demo.appointments.generated_soap_dto.shifts;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="doctor_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="start_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="end_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="time_start" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="time_end" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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

    @XmlElement(name = "doctor_id", required = true)
    protected String doctorId;
    @XmlElement(name = "start_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "end_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElementRef(name = "period", namespace = "http://www.appointments.demo.com/generated_soap_dto/shifts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> period;
    @XmlElementRef(name = "time_start", namespace = "http://www.appointments.demo.com/generated_soap_dto/shifts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> timeStart;
    @XmlElementRef(name = "time_end", namespace = "http://www.appointments.demo.com/generated_soap_dto/shifts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> timeEnd;

    /**
     * Gets the value of the doctorId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * Sets the value of the doctorId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDoctorId(String value) {
        this.doctorId = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the period property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setPeriod(JAXBElement<String> value) {
        this.period = value;
    }

    /**
     * Gets the value of the timeStart property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    public JAXBElement<Integer> getTimeStart() {
        return timeStart;
    }

    /**
     * Sets the value of the timeStart property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    public void setTimeStart(JAXBElement<Integer> value) {
        this.timeStart = value;
    }

    /**
     * Gets the value of the timeEnd property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    public JAXBElement<Integer> getTimeEnd() {
        return timeEnd;
    }

    /**
     * Sets the value of the timeEnd property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    public void setTimeEnd(JAXBElement<Integer> value) {
        this.timeEnd = value;
    }

}