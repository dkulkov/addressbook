package ru.stqa.pft.addressbook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class TestBase {
    private final StringBuffer verificationErrors = new StringBuffer();
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private String baseUrl;

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

    protected void submitContact() {
        driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    protected void createNewContact(ContactData contactData) {
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

    protected void goToContactForm() {
        driver.findElement(By.linkText("add new")).click();
        driver.get("http://localhost/addressbook/edit.php");
    }

    protected void logOut() {
        driver.findElement(By.linkText("Logout")).click();
    }

    protected void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void submit() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
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

    protected void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    protected void goToGroupPage() {
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

    protected void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }
}
