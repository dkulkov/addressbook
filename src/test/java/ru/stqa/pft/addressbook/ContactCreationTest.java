package ru.stqa.pft.addressbook;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        goToContactForm();
        createNewContact(new ContactData("Anton", "Melnikov", "89033224931", "antoha@mail.ru"));
        submitContact();
        logOut();
    }

}
