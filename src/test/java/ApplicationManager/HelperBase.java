package ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class HelperBase {
    protected FirefoxDriver driver;

    public HelperBase(FirefoxDriver driver) {
        this.driver= driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text!=null){
            String existingElement = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingElement)){
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }
    protected void attach(By locator, File file) {
        if (file!=null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
            }
        }

    private boolean isAlertPresent () {
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException ex) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
