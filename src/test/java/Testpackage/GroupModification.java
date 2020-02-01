package Testpackage;
import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;
public class GroupModification extends TestBase {
    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup((new GroupData("blah", null, null)));
        }
        app.getGroupHelper().selectGroup(1);
        app.getGroupHelper().initGroupModofocation();
        app.getGroupHelper().fillGroupForm(new GroupData("123", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
