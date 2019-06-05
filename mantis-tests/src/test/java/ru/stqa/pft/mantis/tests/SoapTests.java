package ru.stqa.pft.mantis.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.ptf.mantis.model.Issue;
import ru.stqa.ptf.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase {

    @BeforeTest
    public void skipNotFixed() throws IOException, ServiceException {
            //skipIfNotFixed(0000001);                    //интеграция с mantis - SOAP
            skipIfNotFixedBugify(1513);                 //интеграция с Bugify - REST
    }

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for(Project project : projects)
        {
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {

        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("TestIssue").withDescription("TestDesc").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        Assert.assertEquals(issue.getSummary(),created.getSummary());


    }

}
