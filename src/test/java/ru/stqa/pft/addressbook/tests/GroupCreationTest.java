package ru.stqa.pft.addressbook.tests;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Set;


@Slf4j
public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);


        group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
 }
