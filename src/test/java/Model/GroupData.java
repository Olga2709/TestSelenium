package Model;

import java.util.Objects;

public class GroupData {
    private int id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(int id, String name, String header, String footer) {
        this.name = name;
        this.id = id;
        this.header = header;
        this.footer = footer;
    }
    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.id = 0;
        this.header = header;
        this.footer = footer;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;


        return Objects.equals(id, groupData.id) &&
                Objects.equals(name, groupData.name);

//        if (id !=groupData.id) return false;
//        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode(): 0);
        return  result;

//        return Objects.hash(id, name);
    }
}



