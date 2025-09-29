package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void createNewContact(ContactData contactData) {
        type(By.name("firstname"),contactData.firstName());
        type(By.name("lastname"),contactData.lastName()) ;
        type(By.name("mobile"),contactData.mobile());
        type(By.name("email"),contactData.email());

    }

    public void goToContactForm() {
        click(By.linkText("add new"));

    }
}
