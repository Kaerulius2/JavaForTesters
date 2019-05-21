package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

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

    public void selectUser() {
        click(By.name("selected[]"));
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

    public void createUser(UserData user,boolean cr) {
        initCreationUser();
        fillUserForm(user,cr);
        submitUserCreation();
    }

    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));
    }
}
