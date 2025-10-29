package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


@Slf4j
public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream()
                .mapToInt((c) -> c.getId())
                .max()
                .getAsInt()))));
    }


    @Test
    public void testBadContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test'").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

}
