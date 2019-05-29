package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if(app.db().users().size()==0){
            GroupData someGroup = app.db().groups().iterator().next();
            app.user().create(new UserData().withFirstname("Alex").withMidname("V").withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup(someGroup.getName()),true);
        }
    }

    @Test
    public void testUserDeletionFromHome() throws Exception {
        app.goTo().homePage();
        Users before = app.db().users();
        UserData deletedUser = before.iterator().next();
        app.user().delete(deletedUser);
        app.goTo().homePage();
        Users after = app.db().users();
        assertEquals(after.size(),before.size()-1);

        assertThat(after, equalTo(before.without(deletedUser)));
    }



    @Test
    public void testUserDeletionFromEdit() throws Exception {
        app.goTo().homePage();
        Users before = app.db().users();
        UserData deletedUser = before.iterator().next();
        app.user().deleteFromEdit(deletedUser);
        app.goTo().homePage();
        Users after = app.db().users();
        assertEquals(after.size(),before.size()-1);

        before.remove(deletedUser);
        assertThat(after, equalTo(before.without(deletedUser)));
    }



}
