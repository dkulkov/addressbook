package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
    @Test
    public void contactGroupModification() {
        app.getContactHelper().goToContactForm();
        app.getContactHelper().editContact();
        app.getContactHelper().createNewContact(new ContactData("Katya", "Xxxx", "89995676800", "zzz@mail.ru"));
        app.getContactHelper().updateContact();
    }

}
