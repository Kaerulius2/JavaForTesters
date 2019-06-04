
package com.siebel.customui;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="holdTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="promoCodeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "holdTime",
    "promoCodeName"
})
@XmlRootElement(name = "UALPromotionCodesholdPromoCode_Input")
public class UALPromotionCodesholdPromoCodeInput {

    @XmlElement(required = true)
    protected String holdTime;
    @XmlElement(required = true)
    protected String promoCodeName;

    /**
     * Gets the value of the holdTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldTime() {
        return holdTime;
    }

    /**
     * Sets the value of the holdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldTime(String value) {
        this.holdTime = value;
    }

    /**
     * Gets the value of the promoCodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCodeName() {
        return promoCodeName;
    }

    /**
     * Sets the value of the promoCodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCodeName(String value) {
        this.promoCodeName = value;
    }

}
