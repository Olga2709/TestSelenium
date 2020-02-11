package Model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.annotation.meta.Exhaustive;
import java.util.Objects;
@XStreamAlias("group")
public class GroupData {
    //создадим сеттеры для переменных
    @XStreamOmitField
    private int id =Integer.MAX_VALUE;
    @Expose
    private  String name;
    @Expose
    private  String header;
    @Expose
    private  String footer;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(name, groupData.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
//    @Override
//    public int hashCode() {
//        int result = id;
//        result=31*result+ (name!=null ? name.hashCode():0);
//        return result
//    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getHeader() {
        return header;
    }
    public String getFooter() {
        return footer;
    }
    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public GroupData withId(int id) {
        this.id = id;
        return this;
    }
    public GroupData withName(String name) {
        this.name = name;
        return this;
    }
    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }
    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }
}



