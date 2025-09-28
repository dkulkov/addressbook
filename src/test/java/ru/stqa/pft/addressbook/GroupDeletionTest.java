package ru.stqa.pft.addressbook;

import org.junit.jupiter.api.Test;


public class GroupDeletionTest  extends TestBase {
    
    
    @Test
    public void testGroupDeletion() throws Exception {
        goToGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();

    }
}

