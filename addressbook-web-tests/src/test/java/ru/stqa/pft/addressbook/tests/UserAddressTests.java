package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();

        if(app.user().all().size()==0){
            app.user().create(new UserData().withFirstname("Alex").withMidname("V")
                    .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").withGroup("TestGroup2"),true);
        }
    }

    @Test
    public void testUserAddress(){
        app.goTo().homePage();
        UserData user = app.user().all().iterator().next();
        UserData userInfoFromEditForm = app.user().infoFromEditForm(user);

        assertThat(user.getAddress(), equalTo(userInfoFromEditForm.getAddress()));

    }



}