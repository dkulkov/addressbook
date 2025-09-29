package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void submitContact() {
        driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void createNewContact(ContactData contactData) {
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

    public void goToContactForm() {
        driver.findElement(By.linkText("add new")).click();
        driver.get("http://localhost/addressbook/edit.php");
    }
}
