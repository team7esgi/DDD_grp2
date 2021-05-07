package model.users;

public class Address {

    private final int number;
    private final String streetName;
    private final int zipCode;
    private final String city;
    private final String country;

    public Address(int number, String streetName, int zipCode, String city, String country) {
        this.number = number;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }



}
