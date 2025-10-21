package ru.stqa.pft.addressbook.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;


public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeAll
    public static void  setUp() throws Exception {
        app.init();
    }

    @AfterAll
    public static void tearDown() throws Exception {
        app.stop();

    }

}
