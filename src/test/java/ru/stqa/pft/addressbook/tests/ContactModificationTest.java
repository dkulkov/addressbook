package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
    @Test
    public void contactModificationTest() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Ivanov", "89556768958", "test@mail.ru", "aaaa"), true);
        }
        app.getContactHelper().goToContactForm();
        app.getContactHelper().editContact();
        app.getContactHelper().createNewContact(new ContactData("Katya", "Xxxx", "89995676800", "zzz@mail.ru", null), false);
        app.getContactHelper().updateContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }

}
