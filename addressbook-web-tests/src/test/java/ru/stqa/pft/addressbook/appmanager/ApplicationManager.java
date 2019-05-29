package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private Properties properties;
    WebDriver wd;
    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private String browser;
    private DbHelper DbHelper;

    public ApplicationManager(String browser){

        this.browser=browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target","local");

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
        DbHelper = new DbHelper();

        if(browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("path.chromedriver"));
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", properties.getProperty("path.firefoxdriver"));
            wd = new FirefoxDriver();
        }else if (browser.equals(BrowserType.EDGE)){
            System.setProperty("webdriver.edge.driver", properties.getProperty("path.edgedriver")); //C:\Edgedriver
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        userHelper = new UserHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPass"));
    }


    public void stop() {
        wd.quit();
    }

    public Properties prop() {return properties;}

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public UserHelper user() {
        return userHelper;
    }

    public DbHelper db(){
        return DbHelper;
    }
}
