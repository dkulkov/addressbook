package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


@Slf4j
public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream()
                .max(Comparator.comparing(c -> Integer.parseInt(c.id())))
                .get().id());

        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
