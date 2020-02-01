package Testpackage;
import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GroupModification extends TestBase {
    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup((new GroupData("blah", null, null)));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(1);
        app.getGroupHelper().initGroupModofocation();
        app.getGroupHelper().fillGroupForm(new GroupData("123", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() );
    }
}
