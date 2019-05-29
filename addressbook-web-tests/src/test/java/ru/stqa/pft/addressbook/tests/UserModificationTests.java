package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if(app.db().users().size()==0){
            app.goTo().homePage();
            GroupData someGroup = app.db().groups().iterator().next();
            app.user().create(new UserData().withFirstname("Alex").withMidname("V").withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup(someGroup.getName()),true);
        }
    }

    @Test
    public void testUserModifications() throws Exception {
        app.goTo().homePage();
        Users before = app.db().users();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData().withId(modifiedUser.getId()).withFirstname("Alex_New").withMidname("V")
                .withLastname("Golubkov_new").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withHomePhone("+7911111111")
                .withWorkPhone("+7(499)2223344").withMobilePhone("8-921-222-11-22");
        app.user().modify(user,false);
        app.goTo().homePage();
        Users after = app.db().users();
        assertEquals(after.size(),before.size());

        before.remove(modifiedUser);
        before.add(user);

        assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));
        verifyUserListInUI();
    }




}
