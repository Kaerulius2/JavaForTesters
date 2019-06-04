
package com.siebel.xml.ual_20promotion_20code;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOfUalPromotionCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfUalPromotionCode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UalPromotionCode" type="{http://www.siebel.com/xml/UAL%20Promotion%20Code}UalPromotionCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfUalPromotionCode", propOrder = {
    "ualPromotionCode"
})
public class ListOfUalPromotionCode {

    @XmlElement(name = "UalPromotionCode")
    protected List<UalPromotionCode> ualPromotionCode;

    /**
     * Gets the value of the ualPromotionCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ualPromotionCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUalPromotionCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UalPromotionCode }
     * 
     * 
     */
    public List<UalPromotionCode> getUalPromotionCode() {
        if (ualPromotionCode == null) {
            ualPromotionCode = new ArrayList<UalPromotionCode>();
        }
        return this.ualPromotionCode;
    }

}
