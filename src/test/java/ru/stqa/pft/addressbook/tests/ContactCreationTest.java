package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


@Slf4j
public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToNewContactForm();
        app.getContactHelper().createContact(new ContactData("Test", "Ivanov", "89556768958", "test@mail.ru", "aaaa"), true);
        app.getContactHelper().goToContactForm();
        List<ContactData> after = app.getContactHelper().getContactList();

        Comparator<? super ContactData> byName = Comparator
                .comparing(ContactData::lastName)
                .thenComparing(ContactData::firstName);
        before.sort(byName);
        after.sort(byName);


        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
