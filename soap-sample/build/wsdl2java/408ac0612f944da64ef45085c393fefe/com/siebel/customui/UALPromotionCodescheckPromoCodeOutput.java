
package com.siebel.customui;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.siebel.xml.ual_20promotion_20code.ListOfUalPromotionCode;


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
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.siebel.com/xml/UAL%20Promotion%20Code}ListOfUalPromotionCode" minOccurs="0"/&gt;
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
    "errorCode",
    "errorMessage",
    "listOfUalPromotionCode"
})
@XmlRootElement(name = "UALPromotionCodescheckPromoCode_Output")
public class UALPromotionCodescheckPromoCodeOutput {

    @XmlElement(name = "ErrorCode", required = true)
    protected String errorCode;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "ListOfUalPromotionCode", namespace = "http://www.siebel.com/xml/UAL%20Promotion%20Code")
    protected ListOfUalPromotionCode listOfUalPromotionCode;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

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
