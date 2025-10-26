package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


@Slf4j
public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byName =
                (c1, c2) -> c1.lastname().compareToIgnoreCase(c2.lastname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);
    }

}
