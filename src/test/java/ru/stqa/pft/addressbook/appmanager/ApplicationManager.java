package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;

public class ApplicationManager {

    public WebDriver driver;

    private  ContactHelper contactHelper ;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  GroupHelper groupHelper;
    private boolean acceptNextAlert = true;
    private String baseUrl;

    public void init() {
        String browser = Browser.CHROME.browserName();
        if (browser == Browser.CHROME.browserName()) {
            driver = new ChromeDriver();
        } else if (browser == Browser.FIREFOX.browserName()) {
            driver = new FirefoxDriver();
        } else if (browser == Browser.IE.browserName()) {
            driver = new InternetExplorerDriver();
        }
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("http://localhost/addressbook/index.php");
        driver.get("http://localhost/addressbook/");
        contactHelper = new ContactHelper(driver);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }


    public void logOut() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
       driver.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
