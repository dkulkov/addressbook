package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.ContactData;


@Slf4j
public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.getContactHelper().goToNewContactForm();
        app.getContactHelper().createNewContact(new ContactData("Test", "Ivanov", "89556768958", "test@mail.ru"));
        app.getContactHelper().submitContact();

    }

}
