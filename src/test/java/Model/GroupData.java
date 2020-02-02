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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.id = Integer.MAX_VALUE;
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

    public void setId(int id) {
        this.id = id;
    }

}



