package ru.stqa.ptf.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager app) {

        super(app);
        wd = app.getDriver();
    }

    public void manageUserPage() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_overview_page.php");
        click(By.linkText("Manage Users"));


    }

    public void groupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("New"))) {
            return;
        }
        click(By.linkText("groups"));
    }
}
