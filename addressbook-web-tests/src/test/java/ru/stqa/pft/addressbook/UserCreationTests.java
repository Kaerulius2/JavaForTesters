package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreationsTests() throws Exception {
        initCreationUser();
        fillUserForm(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com"));
        submitUserCreation();
        gotoHomePage();
    }

}
