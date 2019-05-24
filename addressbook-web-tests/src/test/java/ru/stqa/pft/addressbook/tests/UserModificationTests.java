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
        if(!app.user().isThereAUser()){
            app.user().create(new UserData().withFirstname("Alex").withMidname("V").withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup"), true);
        }
        app.goTo().homePage();
        List<UserData> before = app.user().list();
        UserData user = new UserData().withId(before.get(0).getId()).withFirstname("Alex").withMidname("V").withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup");
        app.user().modify(user,false);
        app.goTo().homePage();
        List<UserData> after = app.user().list();
        Assert.assertEquals(after.size(),before.size());

        before.remove(0);
        before.add(user);

        Comparator<? super UserData> byId = (s1, s2) -> Integer.compare(s1.getId(), s2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }




}
