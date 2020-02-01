package Testpackage;
import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase{
    @Test
    public void testGroupeDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) {
          app.getGroupHelper().createGroup(new GroupData("Third", "Group", "Than"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() - 1);
    }
}
