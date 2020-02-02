package Testpackage;

import Model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
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
                GroupData group = new GroupData("Third", null, null);
                app.getGroupHelper().fillGroupForm(group);
                app.getGroupHelper().submitGroupForm();
                app.getGroupHelper().returntoGroupPage();
                List<GroupData> after = app.getGroupHelper().getGroupList();
                Assert.assertEquals(after.size(), before.size() + 1);
//использование компаратора
//                int max = 0;
//                for (GroupData g : after) {
//                    if (g.getId() > max) {
//                        max = g.getId();
//                    }
//                }

                //использования лямбда выражений

              //  Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
                before.add(group);
//                group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

                Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
                before.sort(byId);
                after.sort(byId);
                Assert.assertEquals( before,after);

        }
}

