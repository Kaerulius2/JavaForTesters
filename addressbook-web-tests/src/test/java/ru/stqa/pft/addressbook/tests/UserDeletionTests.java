package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletionFromHome() throws Exception {
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().selectUser(before.size()-1);
        app.getUserHelper().deleteSelectedUser();
        app.getUserHelper().submitUserDeletion();
        app.getNavigationHelper().gotoHomePage();
        List<UserData> after = app.getUserHelper().getUserList();

        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(before.size()-1);

        Assert.assertEquals(before, after);
    }

    @Test
    public void testUserDeletionFromEdit() throws Exception {
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().initModificationUser();
        app.getUserHelper().deleteEditUser();
        app.getNavigationHelper().gotoHomePage();
        List<UserData> after = app.getUserHelper().getUserList();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }

}
