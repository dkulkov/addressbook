package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectContactById(int id ) {
        click(By.xpath("//input[@value='" + id + "']"));
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
            contacts.add (new ContactData()
                    .withFirstname(getByIndexOrNull(name, 1))
                    .withLastname(getByIndexOrNull(name, 0))
                    .withMobile(getByIndexOrNull(name, 3))
                    .withEmail(getByIndexOrNull(name, 2))
                    .withGroup(getByIndexOrNull(name, 4)));
        }
        return contacts;
    }


    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='maintable']//tr[not(@class='header')]"));

        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);


            String idString = row.findElement(By.name("selected[]")).getAttribute("value");
            int id = Integer.parseInt(idString);

            String[] name = row.getText().split("\\s");

            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstname(getByIndexOrNull(name, 1))
                    .withLastname(getByIndexOrNull(name, 0))
                    .withMobile(getByIndexOrNull(name, 3))
                    .withEmail(getByIndexOrNull(name, 2))
                    .withGroup(getByIndexOrNull(name, 4)));
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
        selectContactById(contact.getId());
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

    public void delete(ContactData Contact) {
        selectContactById(Contact.getId());
        deleteSelectedContact();
        acceptAlert();
        returnToContact();
    }
}