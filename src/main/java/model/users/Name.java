package model.users;

public class Name {

    private final String firstName;
    private final  String lastName;


    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {
        this.firstName = "";
        this.lastName="";
    }
}
