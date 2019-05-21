package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;


public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreations() throws Exception {
        app.getUserHelper().initCreationUser();
        app.getUserHelper().fillUserForm(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        app.getUserHelper().submitUserCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}
