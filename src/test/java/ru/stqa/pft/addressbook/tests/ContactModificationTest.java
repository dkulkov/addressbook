package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTest extends TestBase {
    @Test
    public void contactModificationTest() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Ivanov", "89556768958", "test@mail.ru", "aaaa"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToContactForm();
        app.getContactHelper().editContact();
        app.getContactHelper().createNewContact(new ContactData("Katya", "Xxxx", "89995676800", "zzz@mail.ru", null), false);
        app.getContactHelper().updateContact();
        app.getContactHelper().goToContactForm();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after, before);
    }

}
