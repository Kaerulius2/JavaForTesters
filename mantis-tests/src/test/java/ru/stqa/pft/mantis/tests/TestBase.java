package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.ptf.mantis.appmanager.ApplicationManager;
import ru.stqa.ptf.mantis.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;


public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.ftp().restore("config_inc.php","config_inc.php.bak");
        app.stop();
    }

    public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
        Issue issue = app.soap().getIssueById(issueId);
        if(issue.getResolution().equals("fixed")){     //для примера проверяю только Решение, но можно тут же сделать более сложную проверку, добавив ещё проверку Статуса.
            return false;
        }
        return true;
    }

    public  boolean isIssueOpenBugify(int issueID) throws IOException {
        Issue issue = app.rest().getIssueById(issueID);
        if(issue.getResolution().equals("3")){
            return false;
        }else
            return true;
    }

    public void skipIfNotFixedBugify(int issueId) throws IOException, ServiceException {
        if (isIssueOpenBugify(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

}
