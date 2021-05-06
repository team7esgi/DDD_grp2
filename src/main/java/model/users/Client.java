package model.users;

public class Client extends Account {

    private final Name name;
    private final Address address;
    private final String phoneNumber;
    private final String details;


    public Client(String email, String password, Name name, Address address, String phoneNumber, String details) {
        super(email,password);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.details = details;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getDetails() {
        return details;
    }

}
