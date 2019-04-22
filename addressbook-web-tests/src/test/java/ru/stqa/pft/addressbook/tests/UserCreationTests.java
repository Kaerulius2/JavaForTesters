package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;


public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreationsTests() throws Exception {
        app.initCreationUser();
        app.fillUserForm(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com"));
        app.submitUserCreation();
        app.gotoHomePage();
    }

}
