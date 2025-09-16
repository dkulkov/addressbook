package ru.stqa.pft.addressbook;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class TestClass {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private String baseUrl;
    private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeEach
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("http://localhost/addressbook/index.php");
        driver.get("http://localhost/addressbook/group.php");
        login("admin", "secret");
    }

    private void login(String userName, String password) {
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.id("LoginForm")).click();
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void createGroup() {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("moscow", "saratov", "chelyabinsk"));
        submit();
        returnGroupCreation();
        logOut();
    }

    @Test
    public void createContact() {
        goToContactForm();
        createNewContact(new ContactData("Anton", "Melnikov", "89033224931", "antoha@mail.ru"));
        submitContact();
        logOut();
    }

    private void submitContact() {
        driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void createNewContact(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.firstName());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.lastName());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.mobile());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.email());
    }

    private void goToContactForm() {
        driver.findElement(By.linkText("add new")).click();
        driver.get("http://localhost/addressbook/edit.php");
    }

    private void logOut() {
        driver.findElement(By.linkText("Logout")).click();
    }

    private void returnGroupCreation() {
        driver.findElement(By.linkText("group page")).click();
    }

    private void submit() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    private void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    private void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!verificationErrorString.isEmpty()) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
