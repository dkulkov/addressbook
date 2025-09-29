package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.ContactData;


@Slf4j
public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.goToContactForm();
        app.createNewContact(new ContactData("Anton", "Melnikov", "89033224931", "antoha@mail.ru"));
        app.submitContact();
        app.logOut();
    }

}
