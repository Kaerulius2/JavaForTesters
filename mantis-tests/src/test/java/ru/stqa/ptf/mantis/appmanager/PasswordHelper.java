package ru.stqa.ptf.mantis.appmanager;

import org.openqa.selenium.By;

public class PasswordHelper extends HelperBase {

    public PasswordHelper(ApplicationManager app) {
        super(app);
        wd = app.getDriver();
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"),username);
        type(By.name("password"),password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void  submitResetPassword(){
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void selectUser(String user) {

        click(By.linkText(user));

    }

    public void confirmChange(String confirmationLink, String newPass) {
        wd.get(confirmationLink);
        type(By.name("password"),newPass);
        type(By.name("password_confirm"),newPass);
        click(By.cssSelector("input[value='Update User']"));
    }
}
