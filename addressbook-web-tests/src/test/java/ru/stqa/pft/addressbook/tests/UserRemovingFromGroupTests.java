package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRemovingFromGroupTests extends  TestBase {

    @BeforeMethod
    public void ensurePreconditions(){  //вначале проверим, что существует хотя бы одна группа, если нет - создадим
        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test_Group").withHeader("Header").withFooter("Footer"));
        }
        if(app.db().users().size()==0){ //потом проверим, что существует хотя бы один контакт, если нет - создадим
            Groups someGroup = app.db().groups();
            app.user().create(new UserData().withFirstname("Alex").withMidname("V")
                    .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").inGroup(someGroup.iterator().next()),true);
        }

    }

    @Test
    public void removeUserFromGroup(){
        app.goTo().homePage();
        Groups existingGroup = app.db().groups(); //выберем имеющиеся группы
        //отберем контакты, которые состоят как минимум в одной группе
        Users usersNotInAllGroups = app.db().users().stream().filter((u)->u.getGroups().size() > 0)
                .collect(Collectors.toCollection(Users::new));
        //если таких нет - нужно создать
        if(usersNotInAllGroups.size()==0){

            UserData freshUser = new UserData().withFirstname("Alex").withMidname("V")
                    .withLastname("Golubkov").withAddress("100111 Tvetskaya str 123").withEmail("q@q.ru").inGroup(existingGroup.iterator().next());
            app.user().create(freshUser,true);
            //
            usersNotInAllGroups = app.db().users().stream().filter((u)->u.getGroups().size() > 0)
                    .collect(Collectors.toCollection(Users::new));
        }

        app.goTo().homePage();
        UserData userToRemove = usersNotInAllGroups.iterator().next(); //выбираем из множства контакт для добавления в группу
        GroupData groupToRemoveFrom = userToRemove.getGroups().iterator().next();
        app.user().removeFromGroup(userToRemove, groupToRemoveFrom);
        //отфильтруем из БД по ID контакт, который удаляли из группы
        UserData modifiedFromDb = app.db().users().stream().filter((u)->u.getId() == userToRemove.getId()).collect(Collectors.toList()).iterator().next();
        //сравним группы контакта из БД с группами контакта, который удаляли с учётом группы
        assertThat(modifiedFromDb.getGroups(), equalTo(userToRemove.getGroups().without(groupToRemoveFrom)));


    }

}
