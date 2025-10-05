package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import ru.stqa.pft.addressbook.model.GroupData;


@Slf4j
public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("moscow", null, null));
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupPage();
            }
 }
