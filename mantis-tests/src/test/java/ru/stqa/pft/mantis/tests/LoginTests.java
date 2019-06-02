package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.*;

public class LoginTests  extends  TestBase{

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();

        assertTrue(session.login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPass")));
        assertTrue(session.isLoggedInAs(app.getProperty("web.adminLogin")));

    }

}
