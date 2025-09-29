package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import static org.junit.jupiter.api.Assertions.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void setUp() throws Exception {
        app.init();
    }

    @AfterEach
    public void tearDown() throws Exception {
        app.stop();
        String verificationErrorString = app.verificationErrors.toString();
        if (!verificationErrorString.isEmpty()) {
            fail(verificationErrorString);
        }
    }

}
