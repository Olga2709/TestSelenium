package ApplicationManager;

import Model.GroupData;
import Model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.management.GarbageCollectorMXBean;
import java.util.*;

public class GroupHelper extends HelperBase {

//супер - это обращение к конструктору базового класса
    public GroupHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void returntoGroupPage() {
        click(By.xpath("//a[contains(text(),'group page')]"));
    }

    public void submitGroupForm() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.xpath("//input[@name='new']"));
    }
    public void deleteGroup() {
        click(By.name("delete"));
    }
    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='"+ id +"']")).click();
    }
    public void initGroupModofocation() {
        click(By.name("edit"));
    }
    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupForm();
        groupCash = null;
        returntoGroupPage();
    }
    public void modify( GroupData group) {
        selectGroupById(group.getId());
        initGroupModofocation();
        fillGroupForm(group);
        submitGroupModification();
        groupCash = null;
        returntoGroupPage();
    }
    public void deleted(GroupData group) {
        selectGroupById(group.getId());
        deleteGroup();
        groupCash = null;
        returntoGroupPage();
    }
    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }
    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Groups groupCash = null;


//    public List <GroupData> list() {
//        List<GroupData> groups = new ArrayList<GroupData>();
//        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
//        for (WebElement element : elements){
//            String name = element.getText();
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            groups.add(new GroupData().withId(id).withName(name));
//        }
//        return groups;
//    }

    public Groups all() {
        if (groupCash !=null){
            return new Groups(groupCash);
        }
        groupCash = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCash.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCash);
    }
}
