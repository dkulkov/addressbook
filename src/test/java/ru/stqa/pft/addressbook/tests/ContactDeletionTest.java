package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends  TestBase {
    @Test

    public void contactDeletionTest() {
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Ivanov", "89556768958", "test@mail.ru", "aaaa"), true);
        }
        app.getContactHelper().goToContactForm();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmDeletion();
        app.getContactHelper().goToContactForm();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

    }
}


