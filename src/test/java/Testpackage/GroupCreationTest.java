package Testpackage;
import Model.GroupData;
import Model.Groups;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

    }
}
//                group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//использование компаратора
//                int max = 0;
//                for (GroupData g : after) {
//                    if (g.getId() > max) {
//                        max = g.getId();
//                    }
//                }

//использования лямбда выражений

//  Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

