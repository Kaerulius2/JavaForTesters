package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;


public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreations() throws Exception {
        app.goTo().homePage();
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().initCreationUser();
        UserData user = new UserData("Alex", "V", "Golubkov", "100111 Tvetskaya str 123", "+79991112233", "email@email.com", "TestGroup");
        app.getUserHelper().fillUserForm(user, true);
        app.getUserHelper().submitUserCreation();
        app.goTo().homePage();
        List<UserData> after = app.getUserHelper().getUserList();
        Assert.assertEquals(after.size(),before.size()+1);

        before.add(user);

        Comparator<? super UserData> byId = (s1, s2) -> Integer.compare(s1.getId(), s2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}
