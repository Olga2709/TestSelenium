package Model;

import java.util.Objects;

public class GroupData {
    private String id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String id, String name, String header, String footer) {
        this.name = name;
        this.id = id;
        this.header = header;
        this.footer = footer;
    }
    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.id = null;
        this.header = header;
        this.footer = footer;
    }

    public String getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(id, groupData.id) &&
                Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}




//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
//    @Override
//    public String toString() {
//        return "GropData{" + "id=' " +id +
//                "name'" + name + '\'' +
//                " }";
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this==obj) return true;
//        if (obj == null || getClass()! = obj.getClass()) return false;
//
//        GroupData groupData = (GroupData) obj;
//        if (id ! = null ? !id.equals(groupData.id))
//
//        return name! = null ? name.equals(groupData.name) : groupData.name==null;
//    }
//}
