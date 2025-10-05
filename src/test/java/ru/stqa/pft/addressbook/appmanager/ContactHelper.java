package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createNewContact(ContactData contactData,boolean creation) {
        type(By.name("firstname"),contactData.firstName());
        type(By.name("lastname"),contactData.lastName()) ;
        type(By.name("mobile"),contactData.mobile());
        type(By.name("email"),contactData.email());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
        } else {
            Assert.assertFalse(isElementPresent (By.name("new_group")));
        }


    
    }

    public void selectContact() {
        click(By.xpath("//table[@id='maintable']//tr[2]/td[1]/input"));
    }

    public void editContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmDeletion() {
        driver.switchTo().alert().accept();
    }


    public void goToContactForm() {
        click(By.linkText("home"));
    }


    public void updateContact() {
        click(By.name("update"));
    }

    public void goToNewContactForm() {
        click(By.linkText("add new"));

    }
}
