package Testpackage;
import Model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class GroupModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size()==0) {
            app.group().create((new GroupData().withName("Test4")));
        }
    }

    @Test
    public void testGroupModification() {

        List<GroupData> before = app.group().list();
        int index = before.size() -1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("test1")
                .withFooter("blah").withFooter("hhh").withHeader("trtrt");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(before.size()-1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals( before,after);
    }


}
