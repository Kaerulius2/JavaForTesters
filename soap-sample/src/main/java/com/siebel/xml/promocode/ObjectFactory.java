
package com.siebel.xml.promocode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.siebel.xml.promocode package. 
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

    private final static QName _PromoCode_QNAME = new QName("http://www.siebel.com/xml/PromoCode", "PromoCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.siebel.xml.promocode
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PromoCode }
     * 
     */
    public PromoCode createPromoCode() {
        return new PromoCode();
    }

    /**
     * Create an instance of {@link PromoCodeTopElmt }
     * 
     */
    public PromoCodeTopElmt createPromoCodeTopElmt() {
        return new PromoCodeTopElmt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PromoCode }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PromoCode }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.siebel.com/xml/PromoCode", name = "PromoCode")
    public JAXBElement<PromoCode> createPromoCode(PromoCode value) {
        return new JAXBElement<PromoCode>(_PromoCode_QNAME, PromoCode.class, null, value);
    }

}
