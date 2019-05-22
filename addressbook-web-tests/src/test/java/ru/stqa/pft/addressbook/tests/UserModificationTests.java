package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTests extends TestBase {

    @Test
    public void testUserModifications() throws Exception {
        app.goTo().homePage();
        if(!app.getUserHelper().isThereAUser()){
            app.getUserHelper().createUser(new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup"), true);
        }
        app.goTo().homePage();
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().initModificationUser();
        UserData user = new UserData(before.get(0).getId(),"Alex_new", "V_new", "Golubkov_new", "100111 Tvetskaya str 123_new", "+79991112233_new", "email@email_new.com",null);
        app.getUserHelper().fillUserForm(user, false);
        app.getUserHelper().submitUserModification();
        app.goTo().homePage();
        List<UserData> after = app.getUserHelper().getUserList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(0);
        before.add(user);

        Comparator<? super UserData> byId = (s1, s2) -> Integer.compare(s1.getId(), s2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }


}
