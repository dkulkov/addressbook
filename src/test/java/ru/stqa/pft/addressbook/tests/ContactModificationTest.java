package ru.stqa.pft.addressbook.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withGroup(null));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withGroup(null);
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));

        before.remove(modifiedContact);
        before.add(contact);
        assertThat(after, equalTo(before));
    }
}