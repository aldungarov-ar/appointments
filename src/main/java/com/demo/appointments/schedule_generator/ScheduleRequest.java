//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.04 at 12:57:38 PM GET 
//


package com.demo.appointments.schedule_generator;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rule" type="{http://www.appointments.demo.com/scehdule}rule"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@SuppressWarnings({"LombokGetterMayBeUsed",
        "LombokSetterMayBeUsed",
        "JavadocLinkAsPlainText", "unused"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "rule"
})
@XmlRootElement(name = "scheduleRequest")
public class ScheduleRequest {

    @XmlElement(required = true)
    protected Rule rule;

    /**
     * Gets the value of the rule property.
     *
     * @return possible object is
     * {@link Rule }
     */
    public Rule getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     *
     * @param value allowed object is
     *              {@link Rule }
     */
    public void setRule(Rule value) {
        this.rule = value;
    }

}