package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletionFromHome() throws Exception {
        if(!app.user().isThereAUser()){
            app.user().create(new UserData().withFirstname("Alex").withMidname("V").withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup"), true);
        }
        app.goTo().homePage();
        List<UserData> before = app.user().list();
        int index=before.size()-1;
        app.user().delete(index);
        app.goTo().homePage();
        List<UserData> after = app.user().list();

        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }



    @Test
    public void testUserDeletionFromEdit() throws Exception {
        if(!app.user().isThereAUser()){
            app.user().create(new UserData().withFirstname("Alex").withMidname("V").withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup"), true);
        }
        app.goTo().homePage();
        List<UserData> before = app.user().list();
        app.user().deleteFromEdit();
        app.goTo().homePage();
        List<UserData> after = app.user().list();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }



}
