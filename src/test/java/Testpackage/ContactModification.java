package Testpackage;

import Model.ContactData;
import org.testng.annotations.Test;

public class ContactModification extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
     app.goTo().gotoHomePage();
     app.contact().initContactModification();
     app.contact().fillContactForm(new ContactData());
     app.contact().submitContactModification();
     app.contact().returntoHomePage();


    }
}
