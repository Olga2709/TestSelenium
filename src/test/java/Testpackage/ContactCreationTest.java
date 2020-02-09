package Testpackage;

import Model.ContactData;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTest extends TestBase
{

    @Test()
    public void testContactCreation() {
        ContactData contact = new ContactData();
       app.contact().initContactCreation(contact.getId());
        File photo = new File("src/test/java/resources/manager.png");
        app.contact().fillContactForm(
               new ContactData().withFirstname("hvj,bb nvbnm").withLastname("bgjhbjvghb").withPhoto(photo));
       app.contact().submitContactCreation();
       app.contact().returntoHomePage();

    }
}
