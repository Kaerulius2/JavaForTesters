package ru.stqa.pft.addressbook;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("TestGroup", "Test1", "Test2"));
        submitGroupCreation();
        returnToGroupPage();

    }


}
