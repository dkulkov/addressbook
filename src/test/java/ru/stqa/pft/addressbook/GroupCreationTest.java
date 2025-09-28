package ru.stqa.pft.addressbook;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("moscow", "saratov", "chelyabinsk"));
        submit();
        returnToGroupPage();
        logOut();
    }
 }
