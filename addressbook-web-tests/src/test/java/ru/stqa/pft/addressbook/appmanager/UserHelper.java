package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void fillUserForm(UserData userData, boolean creation) {
        type(By.name("firstname"),userData.getFirstname());
        type(By.name("middlename"),userData.getMidname());
        type(By.name("lastname"),userData.getLastname());
        type(By.name("address"),userData.getAddress());
        type(By.name("home"),userData.getHomePhone());
        type(By.name("work"),userData.getWorkPhone());
        type(By.name("mobile"),userData.getMobilePhone());
        type(By.name("email"),userData.getEmail());

        if(creation) {
            if (userData.getGroups().size() > 0) {

                Assert.assertTrue(userData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroups().iterator().next().getName());
            }
        }
        else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitUserCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));

    }

    public void initCreationUser() {
        click(By.linkText("add new"));

    }

    public void initModificationUser() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void initModificationUserById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id))).findElement(By.xpath("./../../td[8]/a"));
        checkbox.click();
    }

    public void submitUserModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }


    public void selectUserById(int id) {

        wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
    }

    public void selectGroupNameByValue(String groupName){
        new Select(wd.findElement(By.name("to_group"))).selectByValue(groupName);
    }

    public void deleteSelectedUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitUserDeletion() {
        wd.switchTo().alert().accept();
    }

    public void submitAddingToGroup(){

        click(By.xpath("//input[@value='Add to']"));
    }

    public void deleteEditUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void deleteFromEdit(UserData user) {
      initModificationUserById(user.getId());
      deleteEditUser();
      userCache = null;
    }

    public void addToGroup(UserData user, GroupData group){
        selectUserById(user.getId());
        selectGroupNameByValue(Integer.toString(group.getId()));
        submitAddingToGroup();
        userCache = null;
    }

    public void modify(UserData user, boolean cre) {
      initModificationUserById(user.getId());
      fillUserForm(user, cre);
      submitUserModification();
      userCache = null;
    }

    public void delete(UserData user) {
        selectUserById(user.getId());
        deleteSelectedUser();
        submitUserDeletion();
        userCache = null;
    }

    public void create(UserData user, boolean cr) {
        initCreationUser();
        fillUserForm(user,cr);
        submitUserCreation();
        userCache = null;
    }

    public UserData infoFromEditForm(UserData user) {

        initModificationUserById(user.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();

        return new UserData().withId(user.getId()).withFirstname(firstname).withLastname(lastname).withAddress(address)
                .withHomePhone(home).withWorkPhone(work).withMobilePhone(mobile).withEmail(email).withEmail2(email2).withEmail3(email3);
    }


    private Users userCache = null;

    public Users all() {
        if(userCache!=null){
            return new Users(userCache);
        }

        userCache = new Users();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
        for(WebElement element : elements){
            List<WebElement> fields = element.findElements(By.tagName("td"));
            String lastname = fields.get(1).getText();
            String firstname = fields.get(2).getText();
            String addr = fields.get(3).getText();
            String allphones = fields.get(5).getText();
            String allemails = fields.get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            userCache.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(addr).withAllPhones(allphones).withallemails(allemails));
        }
        return new Users(userCache);
    }


}
