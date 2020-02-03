package Testpackage;

import Model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase
{

    @Test(enabled = false)
    public void testContactCreation() {
       app.getContactHelper().initContactCreation();
       app.getContactHelper().fillContactForm(new ContactData("Olga ", "Ivanova", "Shvager", "123"), true);
       app.getContactHelper().submitContactCreation();
       app.getContactHelper().returntoHomePage();

    }
}
