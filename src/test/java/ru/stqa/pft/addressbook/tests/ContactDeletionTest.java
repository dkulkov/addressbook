package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends  TestBase{
    @Test

    public void contactDeletionTest() {
        app.getContactHelper().goToContactForm();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();

    }
}


