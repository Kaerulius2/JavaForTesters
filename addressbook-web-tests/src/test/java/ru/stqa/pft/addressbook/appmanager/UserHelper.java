package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
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
        type(By.name("home"),userData.getHomephone());
        type(By.name("email"),userData.getEmail());
        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        }else{
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

    public void submitUserModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void selectUser(int i) {

        wd.findElements(By.name("selected[]")).get(i).click();
    }

    public void deleteSelectedUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitUserDeletion() {
        wd.switchTo().alert().accept();
    }

    public void deleteEditUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void deleteFromEdit() {
      initModificationUser();
      deleteEditUser();
    }

    public void modify(UserData user, boolean cre) {
      initModificationUser();
      fillUserForm(user, cre);
      submitUserModification();
    }

    public void delete(int index) {
        selectUser(index);
        deleteSelectedUser();
        submitUserDeletion();
    }

    public void create(UserData user, boolean cr) {
        initCreationUser();
        fillUserForm(user,cr);
        submitUserCreation();
    }


    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<UserData> list() {
        List<UserData> users = new ArrayList<UserData>();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
        for(WebElement element : elements){
            List<WebElement> fields = element.findElements(By.tagName("td"));
            String lastname = fields.get(1).getText();
            String firstname = fields.get(2).getText();
            String addr = fields.get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            UserData user = new UserData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(addr);
            users.add(user);
        }
        return users;
    }
}
