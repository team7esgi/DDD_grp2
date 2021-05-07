package model.dishes;

import model.ObjectId;
import model.rate.Rate;

public class Dishes {

    private ObjectId id;
    private Description description;
    private ObjectId restaurantId;
    private Rate rate;
    private boolean isAvailable;

    public Dishes(ObjectId id, Description description, ObjectId restaurantId, Rate rate, boolean isAvailable) {
        this.id = id;
        this.description = description;
        this.restaurantId = restaurantId;
        this.rate = rate;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id=" + id +
                ", description=" + description +
                ", restaurantId=" + restaurantId +
                ", rate=" + rate +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public Dishes() {
    }

    public ObjectId getId() {
        return id;
    }

    public Description getDescription() {
        return description;
    }

    public Rate getRate() {
        return rate;
    }

    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}
