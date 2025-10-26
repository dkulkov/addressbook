package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().list().isEmpty()) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup(null));
        }
    }
    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup(null);
        app.contact().modify(contact);
        List<ContactData> after = app.contact().list();

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byName =
                (c1, c2) -> c1.lastname().compareToIgnoreCase(c2.lastname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);


    }
    }
