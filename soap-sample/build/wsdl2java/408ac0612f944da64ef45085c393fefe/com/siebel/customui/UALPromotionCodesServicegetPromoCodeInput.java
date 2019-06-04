
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
 *         &lt;element name="promoCampaignId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "promoCampaignId"
})
@XmlRootElement(name = "UALPromotionCodesServicegetPromoCode_Input")
public class UALPromotionCodesServicegetPromoCodeInput {

    @XmlElement(required = true)
    protected String promoCampaignId;

    /**
     * Gets the value of the promoCampaignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCampaignId() {
        return promoCampaignId;
    }

    /**
     * Sets the value of the promoCampaignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCampaignId(String value) {
        this.promoCampaignId = value;
    }

}
