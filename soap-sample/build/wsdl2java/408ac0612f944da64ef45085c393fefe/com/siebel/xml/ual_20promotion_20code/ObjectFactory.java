
package com.siebel.xml.ual_20promotion_20code;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.siebel.xml.ual_20promotion_20code package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListOfUalPromotionCode_QNAME = new QName("http://www.siebel.com/xml/UAL%20Promotion%20Code", "ListOfUalPromotionCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.siebel.xml.ual_20promotion_20code
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListOfUalPromotionCode }
     * 
     */
    public ListOfUalPromotionCode createListOfUalPromotionCode() {
        return new ListOfUalPromotionCode();
    }

    /**
     * Create an instance of {@link ListOfUalPromotionCodeTopElmt }
     * 
     */
    public ListOfUalPromotionCodeTopElmt createListOfUalPromotionCodeTopElmt() {
        return new ListOfUalPromotionCodeTopElmt();
    }

    /**
     * Create an instance of {@link UalPromotionCode }
     * 
     */
    public UalPromotionCode createUalPromotionCode() {
        return new UalPromotionCode();
    }

    /**
     * Create an instance of {@link ListOfUalPromoCodeCampaignDirection }
     * 
     */
    public ListOfUalPromoCodeCampaignDirection createListOfUalPromoCodeCampaignDirection() {
        return new ListOfUalPromoCodeCampaignDirection();
    }

    /**
     * Create an instance of {@link UalPromoCodeCampaignDirection }
     * 
     */
    public UalPromoCodeCampaignDirection createUalPromoCodeCampaignDirection() {
        return new UalPromoCodeCampaignDirection();
    }

    /**
     * Create an instance of {@link ListOfInternalAddServices }
     * 
     */
    public ListOfInternalAddServices createListOfInternalAddServices() {
        return new ListOfInternalAddServices();
    }

    /**
     * Create an instance of {@link AddService }
     * 
     */
    public AddService createAddService() {
        return new AddService();
    }

    /**
     * Create an instance of {@link ListOfRate }
     * 
     */
    public ListOfRate createListOfRate() {
        return new ListOfRate();
    }

    /**
     * Create an instance of {@link Rate }
     * 
     */
    public Rate createRate() {
        return new Rate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOfUalPromotionCode }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListOfUalPromotionCode }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.siebel.com/xml/UAL%20Promotion%20Code", name = "ListOfUalPromotionCode")
    public JAXBElement<ListOfUalPromotionCode> createListOfUalPromotionCode(ListOfUalPromotionCode value) {
        return new JAXBElement<ListOfUalPromotionCode>(_ListOfUalPromotionCode_QNAME, ListOfUalPromotionCode.class, null, value);
    }

}
