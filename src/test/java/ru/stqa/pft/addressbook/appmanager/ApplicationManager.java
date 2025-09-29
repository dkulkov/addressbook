package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.time.Duration;

public class ApplicationManager {
    protected final StringBuffer verificationErrors = new StringBuffer();
    private final GroupHelper groupHelper = new GroupHelper();
    private boolean acceptNextAlert = true;
    private String baseUrl;

    public void init() {
        groupHelper.driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        groupHelper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        groupHelper.driver.get("http://localhost/addressbook/index.php");
        groupHelper.driver.get("http://localhost/addressbook/group.php");
        login("admin", "secret");
    }

    private void login(String userName, String password) {
        groupHelper.driver.findElement(By.name("user")).clear();
        groupHelper.driver.findElement(By.name("user")).sendKeys(userName);
        groupHelper.driver.findElement(By.id("LoginForm")).click();
        groupHelper.driver.findElement(By.name("pass")).click();
        groupHelper.driver.findElement(By.name("pass")).clear();
        groupHelper.driver.findElement(By.name("pass")).sendKeys(password);
        groupHelper.driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void submitContact() {
        groupHelper.driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void createNewContact(ContactData contactData) {
        groupHelper.driver.findElement(By.name("firstname")).click();
        groupHelper.driver.findElement(By.name("firstname")).clear();
        groupHelper.driver.findElement(By.name("firstname")).sendKeys(contactData.firstName());
        groupHelper.driver.findElement(By.name("lastname")).click();
        groupHelper.driver.findElement(By.name("lastname")).clear();
        groupHelper.driver.findElement(By.name("lastname")).sendKeys(contactData.lastName());
        groupHelper.driver.findElement(By.name("mobile")).click();
        groupHelper.driver.findElement(By.name("mobile")).clear();
        groupHelper.driver.findElement(By.name("mobile")).sendKeys(contactData.mobile());
        groupHelper.driver.findElement(By.name("email")).click();
        groupHelper.driver.findElement(By.name("email")).clear();
        groupHelper.driver.findElement(By.name("email")).sendKeys(contactData.email());
    }

    public void goToContactForm() {
        groupHelper.driver.findElement(By.linkText("add new")).click();
        groupHelper.driver.get("http://localhost/addressbook/edit.php");
    }

    public void logOut() {
        groupHelper.driver.findElement(By.linkText("Logout")).click();
    }

    public void goToGroupPage() {
        groupHelper.driver.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        groupHelper.driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
