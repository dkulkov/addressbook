package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {
    public boolean acceptNextAlert = true;

    public ContactHelper(WebDriver driver) {
        super(driver);
    }


    public void returnToContact() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.firstname());
        type(By.name("lastname"), contactData.lastname());
        type(By.name("mobile"), contactData.mobile());
        type(By.name("email"), contactData.email());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContactCreation() {
        click(By.linkText("add new"));
        driver.get("http://localhost/addressbook/edit.php");
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact( ) {
        click(By.xpath("//table[@id='maintable']//tr[2]/td[1]/input"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void create(ContactData contact) {
        selectContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContact();
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']//tr[2]/td[1]/input"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='maintable']//tr[not(@class='header')]"));
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                continue;
            }
            String[] name = elements.get(i).getText().split("\\s");
            ContactData contact = new ContactData(
                    getByIndexOrNull(name, 1),
                    getByIndexOrNull(name, 0),
                    getByIndexOrNull(name, 3),
                    getByIndexOrNull(name, 2),
                    getByIndexOrNull(name, 4));
            contacts.add(contact);
        }
        return contacts;
    }

    private String getByIndexOrNull(String[] s, int index) {
        if (index > s.length - 1) {
            return null;
        }
        return s[index];
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void modify(ContactData contact) {
        selectContact();
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        returnToContact();
    }
    public void delete() {
        selectContact();
        deleteSelectedContact();
        acceptAlert();
        returnToContact();
    }
}