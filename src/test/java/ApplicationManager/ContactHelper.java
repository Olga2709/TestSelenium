package ApplicationManager;

import Model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void initContactCreation () {click(By.linkText("add new"));}

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("middlename"), contactData.getMiddleName());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitContactCreation () {click(By.cssSelector("input:nth-child(87)"));}
    public void initContactModification() {click(By.cssSelector("img[alt='Edit']")); }
    public void submitContactModification() {click(By.name("update"));}
    public void returntoHomePage() {click(By.xpath("//a[text()='home page']"));}

//    public void fillContactForm(String name, String surname, String surname2) {
//
//        driver.findElement(By.name("firstname")).click();
//        driver.findElement(By.name("firstname")).sendKeys(name);
//        driver.findElement(By.name("middlename")).click();
//        driver.findElement(By.name("middlename")).sendKeys(surname);
//        driver.findElement(By.name("theform")).click();
//        driver.findElement(By.name("lastname")).click();
//        driver.findElement(By.name("lastname")).sendKeys(surname2);
//    }

}
