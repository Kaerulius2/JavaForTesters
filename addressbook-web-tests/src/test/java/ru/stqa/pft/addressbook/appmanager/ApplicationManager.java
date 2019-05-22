package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public void init() {


        if(browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", "C:\\Geckodriver\\geckodriver.exe");
            wd = new FirefoxDriver();
        }else if (browser.equals(BrowserType.EDGE)){
            System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\MicrosoftWebDriver.exe"); //C:\Edgedriver
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        userHelper = new UserHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }



    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
