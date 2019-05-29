package ru.stqa.pft.addressbook.tests;

import javafx.beans.binding.Bindings;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserPhoneTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){

        if(app.db().users().size()==0){
          //  app.user().create(new UserData().withFirstname("Alex").withMidname("V")
          //          .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup2"),true);
        }
    }

    @Test
    public void testUserPhones(){
        app.goTo().homePage();
        UserData user = app.user().all().iterator().next();
        UserData userInfoFromEditForm = app.user().infoFromEditForm(user);

        assertThat(user.getAllphones(), equalTo(mergePhones(userInfoFromEditForm)));

    }

    private String mergePhones(UserData user) {
        return Arrays.asList(user.getHomePhone(),user.getMobilePhone(),user.getWorkPhone())
                .stream().filter((s)->!s.equals(""))
                .map(UserPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String phone){
        return phone.replaceAll("[-()\\s]","");
    }


}
