package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().users().size()==0){
            Groups someGroup = app.db().groups();
            app.user().create(new UserData().withFirstname("Alex").withMidname("V")
                    .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").inGroup(someGroup.iterator().next()),true);
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
