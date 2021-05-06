package model.users;

import java.util.Objects;

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

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(email, client.email) &&
                Objects.equals(password, client.password) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(address, client.address) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(details, client.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, address, phoneNumber, details);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
