package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class UserAddingToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){  //вначале проверим, что существует хотя бы одна группа, если нет - создадим
        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test_Group2").withHeader("Header").withFooter("Footer"));
        }
        if(app.db().users().size()==0){ //потом проверим, что существует хотя бы один контакт, еси нет - создадим
            Groups someGroup = app.db().groups();
            app.user().create(new UserData().withFirstname("Alex").withMidname("V")
                    .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").inGroup(someGroup.iterator().next()),true);
        }

    }

    @Test
    public void addUserToGroup(){
        app.goTo().homePage();
        Groups existingGroup = app.db().groups(); //выберем имеющиеся группы
        //отберем контакты, количества групп которых меньше, чем количество групп всего
        Users usersNotInAllGroups = app.db().users().stream().filter((u)->u.getGroups().size() < existingGroup.size())
                .collect(Collectors.toCollection(Users::new));
        //если не нашли такие контакты, создадим свежий - гарантированно не включенный в группу и добавим его в множество
        if(usersNotInAllGroups.size()==0){
            Groups someGroup = app.db().groups();
            UserData freshUser = new UserData().withFirstname("Alex").withMidname("V")
                    .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru");
            app.user().create(freshUser,true);
            //
            usersNotInAllGroups = app.db().users().stream().filter((u)->u.getGroups().size() < existingGroup.size())
                    .collect(Collectors.toCollection(Users::new));
        }
        app.goTo().homePage();

        UserData userToAdd = usersNotInAllGroups.iterator().next(); //выбираем из множства контакт для добавления в группу
        existingGroup.removeAll(userToAdd.getGroups()); //удалим из множества доступны групп те, в которых состоит выбранный контакт
        GroupData groupToAdd = existingGroup.iterator().next();
        app.user().addToGroup(userToAdd,groupToAdd); //добавим контакт в одну из групп, в которых он не состоит
        //отфильтруем из БД по ID контакт, к которому добавляли группу
        UserData modifiedFromDb = app.db().users().stream().filter((u)->u.getId() == userToAdd.getId()).collect(Collectors.toList()).iterator().next();
        //сравним контакт из БД с контактом, который добавляли с учётом группы
        assertThat(modifiedFromDb.getGroups(), equalTo(userToAdd.getGroups().withAdded(groupToAdd)));

    }

}
