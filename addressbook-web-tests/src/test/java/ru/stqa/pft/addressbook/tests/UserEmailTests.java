package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){


        if(app.db().users().size()==0){
            app.goTo().homePage();
           // app.user().create(new UserData().withFirstname("Alex").withMidname("V")
            //        .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup2"),true);
        }
    }

    @Test
    public void testUserEmails(){
        app.goTo().homePage();
        UserData user = app.user().all().iterator().next();
        UserData userInfoFromEditForm = app.user().infoFromEditForm(user);

        assertThat(user.getAllemails(), equalTo(mergeEmail(userInfoFromEditForm)));

    }

    private String mergeEmail(UserData user) {
        return Arrays.asList(user.getEmail(),user.getEmail2(),user.getEmail3())
                .stream().filter((s)->!s.equals(""))
                .collect(Collectors.joining("\n"));

    }
}
