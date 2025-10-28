package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {
    @BeforeEach
    public void ensurePreconditions() {
        if (app.contact().list().isEmpty()) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }
}

