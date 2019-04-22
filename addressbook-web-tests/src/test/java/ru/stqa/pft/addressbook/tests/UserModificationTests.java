package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

    @Test
    public void testUserModifications() throws Exception {

        app.getContactHelper().initModificationUser();
        app.getContactHelper().fillUserForm(new UserData("Alex_new", "V_new", "Golubkov_new", "100111 Tvetskaya str 123_new", "+79991112233_new", "email@email_new.com"));
        app.getContactHelper().submitUserModification();
        app.getNavigationHelper().gotoHomePage();
    }


}
