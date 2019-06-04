package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ptf.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

    @Test
    public void changePassword() throws MessagingException, IOException {

        long now=System.currentTimeMillis();
        String user = String.format("User%s",now);
        String password = "password";
        String email = String.format("user%s@localhost",now);
        String newPassword = "password2";

        registerNewUser(user, email, password);
        app.password().login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPass"));
        app.navigate().manageUserPage();
        app.password().selectUser(user);
        app.password().submitResetPassword();
        List<MailMessage> mailMessages = app.james().waitForMail(user,password,100000);
        String confirmationLink = findChangeConfirmLink(mailMessages, email);
        //app.password().confirmChange(confirmationLink,newPassword);       //написал своё подтверждение
        app.registration().finish(confirmationLink,newPassword);            //но работает и метод из регистрации
        assertTrue(app.newSession().login(user,newPassword));
    }

    private void registerNewUser(String user, String email, String password) throws MessagingException {
        app.james().createUser(user,password);
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.james().waitForMail(user,password,100000);
        String confirmationLink = findChangeConfirmLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        app.james().drainEmail(user,password);                      //если не удалить лишнюю почту, фокус не получится )))

    }

    private String findChangeConfirmLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }



}
