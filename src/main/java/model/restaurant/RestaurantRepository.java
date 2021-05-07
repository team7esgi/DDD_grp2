package model.restaurant;

import model.ObjectId;
import model.dishes.Dishes;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findById(ObjectId restaurantId);

    List<Restaurant> findByCategory(ObjectId restaurantId);

    Boolean isOpen(ObjectId restaurantId);

    void rateRestaurant(ObjectId clientId, ObjectId restaurantId, int rate);

    List<Dishes> showRestaurantMenu(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

}
