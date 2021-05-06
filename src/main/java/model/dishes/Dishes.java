package model.dishes;

import java.util.List;

public class Dishes {

    private Long id;

    private String name;

    private String details;

    public Dishes(Long id, String name, String details, float price, Long restaurantId, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.restaurantId = restaurantId;
        this.isAvailable = isAvailable;
    }
    public Dishes(){}

    private float price;

    private Long restaurantId;

    private boolean isAvailable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
