
package com.siebel.xml.ual_20promotion_20code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UalPromotionCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UalPromotionCode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalculationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParentCampaignId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unique" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Exclude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ListOfUalPromoCodeCampaignDirection" type="{http://www.siebel.com/xml/UAL%20Promotion%20Code}ListOfUalPromoCodeCampaignDirection" minOccurs="0"/&gt;
 *         &lt;element name="ListOfInternalAddServices" type="{http://www.siebel.com/xml/UAL%20Promotion%20Code}ListOfInternalAddServices" minOccurs="0"/&gt;
 *         &lt;element name="ListOfRate" type="{http://www.siebel.com/xml/UAL%20Promotion%20Code}ListOfRate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UalPromotionCode", propOrder = {
    "calculationMethod",
    "name",
    "parentCampaignId",
    "rating",
    "status",
    "type",
    "unique",
    "exclude",
    "description",
    "startDate",
    "endDate",
    "listOfUalPromoCodeCampaignDirection",
    "listOfInternalAddServices",
    "listOfRate"
})
public class UalPromotionCode {

    @XmlElement(name = "CalculationMethod")
    protected String calculationMethod;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "ParentCampaignId")
    protected String parentCampaignId;
    @XmlElement(name = "Rating")
    protected String rating;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Type")
    protected String type;
    @XmlElement(name = "Unique")
    protected String unique;
    @XmlElement(name = "Exclude")
    protected String exclude;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "EndDate")
    protected String endDate;
    @XmlElement(name = "ListOfUalPromoCodeCampaignDirection")
    protected ListOfUalPromoCodeCampaignDirection listOfUalPromoCodeCampaignDirection;
    @XmlElement(name = "ListOfInternalAddServices")
    protected ListOfInternalAddServices listOfInternalAddServices;
    @XmlElement(name = "ListOfRate")
    protected ListOfRate listOfRate;

    /**
     * Gets the value of the calculationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalculationMethod() {
        return calculationMethod;
    }

    /**
     * Sets the value of the calculationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalculationMethod(String value) {
        this.calculationMethod = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parentCampaignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCampaignId() {
        return parentCampaignId;
    }

    /**
     * Sets the value of the parentCampaignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCampaignId(String value) {
        this.parentCampaignId = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the unique property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnique() {
        return unique;
    }

    /**
     * Sets the value of the unique property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnique(String value) {
        this.unique = value;
    }

    /**
     * Gets the value of the exclude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExclude() {
        return exclude;
    }

    /**
     * Sets the value of the exclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExclude(String value) {
        this.exclude = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the listOfUalPromoCodeCampaignDirection property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfUalPromoCodeCampaignDirection }
     *     
     */
    public ListOfUalPromoCodeCampaignDirection getListOfUalPromoCodeCampaignDirection() {
        return listOfUalPromoCodeCampaignDirection;
    }

    /**
     * Sets the value of the listOfUalPromoCodeCampaignDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfUalPromoCodeCampaignDirection }
     *     
     */
    public void setListOfUalPromoCodeCampaignDirection(ListOfUalPromoCodeCampaignDirection value) {
        this.listOfUalPromoCodeCampaignDirection = value;
    }

    /**
     * Gets the value of the listOfInternalAddServices property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfInternalAddServices }
     *     
     */
    public ListOfInternalAddServices getListOfInternalAddServices() {
        return listOfInternalAddServices;
    }

    /**
     * Sets the value of the listOfInternalAddServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfInternalAddServices }
     *     
     */
    public void setListOfInternalAddServices(ListOfInternalAddServices value) {
        this.listOfInternalAddServices = value;
    }

    /**
     * Gets the value of the listOfRate property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfRate }
     *     
     */
    public ListOfRate getListOfRate() {
        return listOfRate;
    }

    /**
     * Sets the value of the listOfRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfRate }
     *     
     */
    public void setListOfRate(ListOfRate value) {
        this.listOfRate = value;
    }

}
