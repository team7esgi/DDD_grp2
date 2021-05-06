package model.dishes;

import model.ObjectId;
import model.rate.Rate;

public class Dishes {

    private ObjectId id;

    private Description description;
    private Long restaurantId;

    private Rate rate;

    private boolean isAvailable;

    public ObjectId getId() {
        return id;
    }

    public Description getDescription() {
        return description;
    }

    public Rate getRate() {
        return rate;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}
