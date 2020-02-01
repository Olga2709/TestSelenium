package Model;

public class ContactData {

    private final String name;
    private final String surname;
    private final String surname2;
    private String group;


    public ContactData(String name, String surname, String surname2, String group ) {
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.group = group;
    }

//    public static String getFirstName() {return name;
//    }
//
//    public static String getLastName() {
//    }
//
//    public static String getMiddleName() {
//    }

    public  String getFirstName() {
        return name;
    }

    public  String getLastName() {
        return surname;
    }

    public String getMiddleName() {
        return surname2;
    }

    public String getGroup() {
        return group;
    }
}

