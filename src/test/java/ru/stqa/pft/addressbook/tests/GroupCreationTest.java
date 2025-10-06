package ru.stqa.pft.addressbook.tests;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;


@Slf4j
public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("moscow", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }
 }
