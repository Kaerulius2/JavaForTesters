package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ptf.mantis.model.MailMessage;
import ru.stqa.ptf.mantis.model.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

    @Test
    public void changePassword() throws MessagingException, IOException {

        User userToChangePassword = app.db().getAnyUserFromBD();           //возьмём пользователя из БД
        String user = userToChangePassword.getUsername();
        String passwordForMail = "password";
        String email = userToChangePassword.getEmail();
        String newPassword = "password2";

        //registerNewUser(user, email, password);                                                           //не будем регистрировать нового пользователя
        app.password().login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPass"));
        app.navigate().manageUserPage();
        app.password().selectUser(user);
        app.password().submitResetPassword();
        List<MailMessage> mailMessages = app.james().waitForMail(user,passwordForMail,100000);
        String confirmationLink = findChangeConfirmLink(mailMessages, email);
        app.password().confirmChange(confirmationLink,newPassword);
        assertTrue(app.newSession().login(user,newPassword));
    }


    private String findChangeConfirmLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }



}
