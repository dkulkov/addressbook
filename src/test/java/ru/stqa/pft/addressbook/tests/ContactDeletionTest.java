package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));

        before.remove(deletedContact);
        assertThat(after, equalTo(before));
    }
}


