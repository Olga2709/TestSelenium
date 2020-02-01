package Testpackage;
import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModification extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup((new GroupData("blah", null, null)));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModofocation();
        GroupData group = new GroupData(before.get(before.size()-1).getId(),"222", "123", "123");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() );
        before.remove(before.size()-1);

        before.add(group);
        Assert.assertEquals( new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
