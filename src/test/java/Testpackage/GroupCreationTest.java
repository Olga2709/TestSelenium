package Testpackage;

import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
                GroupData group = new GroupData("Third", null, null);
                app.getGroupHelper().fillGroupForm(group);
                app.getGroupHelper().submitGroupForm();
                app.getGroupHelper().returntoGroupPage();
                List<GroupData> after = app.getGroupHelper().getGroupList();
                Assert.assertEquals(after.size(), before.size() + 1);

                int max = 0;
                for (GroupData g : after) {
                    if (g.getId() > max) {
                        max = g.getId();
                    }
                }
                before.add(group);
                group.setId(max);

                Assert.assertEquals( new HashSet<Object>(before), new HashSet<Object>(after));

        }
}

