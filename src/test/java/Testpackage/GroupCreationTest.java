package Testpackage;

import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GroupCreationTest extends TestBase {

    //    String browser = BrowserType.FIREFOX;
//    if (browser==BrowserType.FIREFOX){
//      driver = new FirefoxDriver();
//    }else if (browser==BrowserType.CHROME){
//      driver=new ChromeDriver();}
//      else {
//        driver =new InternetExplorerDriver();
//      }
//    }
            @Test
        public void testGroupCreation () {

                app.getNavigationHelper().gotoGroupPage();

                List<GroupData> before = app.getGroupHelper().getGroupList();


                app.getGroupHelper().initGroupCreation();
                app.getGroupHelper().fillGroupForm(new GroupData("Third", "Group", "Than"));
                app.getGroupHelper().submitGroupForm();
                app.getGroupHelper().returntoGroupPage();
                List<GroupData> after = app.getGroupHelper().getGroupList();

                Assert.assertEquals(after.size(), before.size() + 1);


        }
}

