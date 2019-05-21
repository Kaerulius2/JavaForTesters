package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletionFromHome() throws Exception {
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getUserHelper().selectUser();
        app.getUserHelper().deleteSelectedUser();
        app.getUserHelper().submitUserDeletion();
        app.getNavigationHelper().gotoHomePage();

    }

    @Test
    public void testUserDeletionFromEdit() throws Exception {
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getUserHelper().initModificationUser();
        app.getUserHelper().deleteEditUser();
        app.getNavigationHelper().gotoHomePage();
    }

}
