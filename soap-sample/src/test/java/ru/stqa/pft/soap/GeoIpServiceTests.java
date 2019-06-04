package ru.stqa.pft.soap;


import com.siebel.customui.UALPromotionCodescheckPromoCodeInput;
import com.siebel.customui.UALPromotionCodescheckPromoCodeOutput;
import com.siebel.xml.promocode.PromoCode;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){

        PromoCode pk= new PromoCode();
        pk.setName("o18Ew9x7");
        pk.setAirportArr("SVX");
        pk.setAirportDept("ZIA");
        pk.setCardNumber("0287734");
        pk.setFlightDate("05/07/2019");

        System.out.println(pk.getNumberOfPassengers());

    }
}
