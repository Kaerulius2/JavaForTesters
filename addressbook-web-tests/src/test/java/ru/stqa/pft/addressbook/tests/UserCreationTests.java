package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


public class UserCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validUsersFromXml() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(app.prop().getProperty("path.data.users.xml")))) {

            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(UserData.class);
            List<UserData> users = (List<UserData>) xStream.fromXML(xml);
            return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator(); //список преобразуем в поток, оборачиваем каждый объект в массив, собираем из массива список, берем итератор
        }
    }

    @DataProvider
    public Iterator<Object[]> validUsersFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(app.prop().getProperty("path.data.users.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<UserData> users = gson.fromJson(json, new TypeToken<List<UserData>>() {
            }.getType()); //List<UserData>.class
            return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator(); //список преобразуем в поток, оборачиваем каждый объект в массив, собираем из массива список, берем итератор
        }
    }
    @BeforeMethod
    public void ensurePreconditions(){ //Если нет групп, то создаем одну, чтобы добавить нового пользователя в эту группу.

        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test_Group").withHeader("Header").withFooter("Footer"));
        }
    }

    @Test(dataProvider = "validUsersFromJson")
    public void testUserCreations(UserData user) throws Exception {
        Groups someGroup = app.db().groups();
        app.goTo().homePage();
        Users before = app.db().users();
        user.inGroup(someGroup.iterator().next());
        app.user().create(user,true);
        Users after = app.db().users();
        assertEquals(after.size(),before.size()+1);

        assertThat(after, equalTo(before.withAdded(user.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }



}
