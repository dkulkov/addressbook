package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasItem;


@Slf4j
public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test2").withGroup("test1");

        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));


        assertThat(after, hasItem(contact.withId(after.stream()
                .mapToInt((c) -> c.getId())
                .max()
                .getAsInt())));
    }
}
