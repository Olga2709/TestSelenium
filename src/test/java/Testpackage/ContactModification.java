package Testpackage;

import Model.ContactData;
import Model.GroupData;
import org.junit.Test;

public class ContactModification extends TestBase {
    @Test
    public void testContactModification() {
     app.getNavigationHelper().gotoHomePage();
        if (!app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Third", "Group", "Than"));
        }
     app.getContactHelper().initContactModification();
     app.getContactHelper().fillContactForm(new ContactData("one","two","three", null), false);
     app.getContactHelper().submitContactModification();
     app.getContactHelper().returntoHomePage();






    }
}
