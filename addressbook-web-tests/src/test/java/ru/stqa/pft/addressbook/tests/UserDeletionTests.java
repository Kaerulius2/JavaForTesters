package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletionFromHome() throws Exception {

        app.getContactHelper().selectUser();
        app.getContactHelper().deleteSelectedUser();
        app.getContactHelper().submitUserDeletion();
        app.getNavigationHelper().gotoHomePage();

    }

    @Test
    public void testUserDeletionFromEdit() throws Exception {
        app.getContactHelper().initModificationUser();
        app.getContactHelper().deleteEditUser();
        app.getNavigationHelper().gotoHomePage();
    }

}
