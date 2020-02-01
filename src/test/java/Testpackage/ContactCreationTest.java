package Testpackage;

import Model.ContactData;
import org.junit.Assert;
import org.junit.Test;

public class ContactCreationTest extends TestBase
{
    @Test
    public void testContactCreation() {

       app.getContactHelper().initContactCreation();
       app.getContactHelper().fillContactForm(new ContactData("Olga ", "Ivanova", "Shvager", "123"), true);
       app.getContactHelper().submitContactCreation();
       app.getContactHelper().returntoHomePage();

    }
}
