package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends  TestBase {
    @Test

    public void contactDeletionTest() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Ivanov", "89556768958", "test@mail.ru", "aaaa"), true);
        }
        app.getContactHelper().goToContactForm();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmDeletion();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);

    }
}


