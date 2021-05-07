package model.restaurant;

import model.ObjectId;
import model.dishes.Dishes;
import model.rate.Rate;
import model.users.Account;
import model.users.Address;

import java.util.List;
import java.util.Optional;

public class Restaurant extends Account {

    private ObjectId id;

    private String name;

    private String category;

    private Address address;

    private List<Dishes> dishesList;

    private boolean isOpen;

    private Rate rate;

    public Restaurant(String email, String password, ObjectId id, String name, String category, Address address, List<Dishes> dishesList, boolean isOpen, Rate rate) {
        super(email, password);
        this.id = id;
        this.name = name;
        this.category = category;
        this.address = address;
        this.dishesList = dishesList;
        this.isOpen = isOpen;
        this.rate = rate;
    }

    private static void verificationOfOpen(boolean isOpen) throws RestaurantException {
        if (!isOpen) throw new RestaurantException("Restaurant closed ! ");
    }
    private static void verificationOfRestaurant(Optional<Restaurant> restaurant) throws RestaurantException {
        if(restaurant.isPresent()) throw new RestaurantException("No such restaurant !");
    }

    public static void VerificationOfExistenceAndAvailability(Optional<Restaurant> restaurant, boolean isOpen) throws RestaurantException {
        verificationOfOpen(isOpen);
        verificationOfRestaurant(restaurant);
    }


    public Restaurant() {
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

    public ObjectId getId() {
        return this.id;
    }
}
