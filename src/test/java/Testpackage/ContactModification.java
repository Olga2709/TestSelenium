package Testpackage;

import Model.ContactData;
import Model.GroupData;
import org.testng.annotations.Test;

public class ContactModification extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
     app.goTo().gotoHomePage();
        if (!app.group().isThereGroup()) {
            app.group().create(new GroupData().withName("Third").withHeader("Group"));
        }
     app.getContactHelper().initContactModification();
     app.getContactHelper().fillContactForm(new ContactData("one","two","three", null), false);
     app.getContactHelper().submitContactModification();
     app.getContactHelper().returntoHomePage();


    }
}
