package model.restaurant;

import model.ObjectId;
import model.dishes.Dishes;
import model.rate.Rate;
import model.users.Account;
import model.users.Address;

import java.util.List;

public class Restaurant extends Account {

    private String name;

    private String category;

    private Address address;

    private List<Dishes> dishesList;

    private boolean isOpen;

    private Rate rate;

    public Restaurant(String email, String password, String name, String category, Address address, List<Dishes> dishesList, boolean isOpen, Rate rate) {
        super(email, password);
        this.name = name;
        this.category = category;
        this.address = address;
        this.dishesList = dishesList;
        this.isOpen = isOpen;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Rate getRate() {
        return rate;
    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

}
