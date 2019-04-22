package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillUserForm(UserData userData) {
        type(By.name("firstname"),userData.getFirstname());
        type(By.name("middlename"),userData.getMidname());
        type(By.name("lastname"),userData.getLastname());
        type(By.name("address"),userData.getAddress());
        type(By.name("home"),userData.getHomephone());
        type(By.name("email"),userData.getEmail());
    }

    public void submitUserCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));

    }

    public void initCreationUser() {
        click(By.linkText("add new"));

    }
}
