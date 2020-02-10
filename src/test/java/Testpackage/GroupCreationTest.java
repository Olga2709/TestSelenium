package Testpackage;
import Model.GroupData;
import Model.Groups;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
    @DataProvider
    //создаем массив сосотоящий из данных файла, при этом делим данные используя регулярные выражения
    public Iterator<Object[]> validGroups () throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/java/resources/resources.xml"))));
        String xml = "";
        String line = reader.readLine();
        while (line!=null){
            xml +=line;
//            String[] split = line.split(";");
//            list.add(new Object[] {new GroupData().
//                    withName(split[0]).
//                    withHeader(split[1]).
//                    withFooter(split[2])});
            line = reader.readLine();
        }
        XStream xStream = new XStream(); //создаем новый обьект типа икстрим
        xStream.processAnnotations(GroupData.class);
        List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
        return groups.stream().map((g) -> new Object[]{g}).
                collect(Collectors.toList()).iterator(); // каждому обьекту нужно применить функцию, которая обьект групдейта завернет в
                                                        // массив который состоит из одног этого обьекта
    }
    @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().getGroupCount(), equalTo(before.size()+1));
        Groups after = app.group().all();
        assertThat(app.group().getGroupCount(),equalTo(before.size()+1));
//        assertThat(after,
//                equalTo(before.withAdded((group.withId(.after.stream().mapToInt((g)->g.getId)).max().getAsInt())));
//                        max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId())));
    }

    //проверка что нельзя создать группу с апострофом
    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test2 '");
        app.group().create(group);
        assertThat(app.group().getGroupCount(), equalTo(before.size()));
        Groups after = app.group().all();

        assertThat(after, equalTo(before));

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

