package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

    @Test
    public void testUserModifications() throws Exception {

        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getUserHelper().initModificationUser();
        app.getUserHelper().fillUserForm(new UserData("Alex_new", "V_new", "Golubkov_new", "100111 Tvetskaya str 123_new", "+79991112233_new", "email@email_new.com",null), false);
        app.getUserHelper().submitUserModification();
        app.getNavigationHelper().gotoHomePage();
    }


}
