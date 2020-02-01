package ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        if(isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.cssSelector(".admin > a"));
    }

    public void gotoHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }

        click(By.xpath("//a[text()='home']"));}
}
