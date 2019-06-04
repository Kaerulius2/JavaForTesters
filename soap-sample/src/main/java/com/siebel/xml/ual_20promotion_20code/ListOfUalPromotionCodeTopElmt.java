
package com.siebel.xml.ual_20promotion_20code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOfUalPromotionCodeTopElmt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfUalPromotionCodeTopElmt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListOfUalPromotionCode" type="{http://www.siebel.com/xml/UAL%20Promotion%20Code}ListOfUalPromotionCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfUalPromotionCodeTopElmt", propOrder = {
    "listOfUalPromotionCode"
})
public class ListOfUalPromotionCodeTopElmt {

    @XmlElement(name = "ListOfUalPromotionCode", required = true)
    protected ListOfUalPromotionCode listOfUalPromotionCode;

    /**
     * Gets the value of the listOfUalPromotionCode property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfUalPromotionCode }
     *     
     */
    public ListOfUalPromotionCode getListOfUalPromotionCode() {
        return listOfUalPromotionCode;
    }

    /**
     * Sets the value of the listOfUalPromotionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfUalPromotionCode }
     *     
     */
    public void setListOfUalPromotionCode(ListOfUalPromotionCode value) {
        this.listOfUalPromotionCode = value;
    }

}
