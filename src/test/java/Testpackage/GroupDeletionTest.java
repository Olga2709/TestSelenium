package Testpackage;
import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;
public class GroupDeletionTest extends TestBase{
    @Test
    public void testGroupeDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().isThereGroup()) {
          app.getGroupHelper().createGroup(new GroupData("Third", "Group", "Than"));
        }
        app.getGroupHelper().selectGroup(before-1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
