package model.dishes;

import model.ObjectId;
import model.command.CommandException;
import model.rate.Rate;

import java.util.List;

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

    public Dishes() {
    }

    public static void verificationOfDishes(List<Dishes> dishesList) throws CommandException {
        for (Dishes dish : dishesList) {
            if (!dish.isAvailable()) throw new CommandException("dish not available");
        }
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
