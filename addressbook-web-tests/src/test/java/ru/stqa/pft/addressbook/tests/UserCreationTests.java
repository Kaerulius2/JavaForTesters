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
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


public class UserCreationTests extends TestBase {


    @Test
    public void testUserCreations() throws Exception {
        app.goTo().homePage();
        Users before = app.user().all();
        UserData user = new UserData().withFirstname("Alex").withMidname("V").withLastname("Golubkov")
                .withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup2");

        app.user().create(user,true);
        app.goTo().homePage();
        Users after = app.user().all();
        assertEquals(after.size(),before.size()+1);


        assertThat(after, equalTo(before.withAdded(user.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }



}
