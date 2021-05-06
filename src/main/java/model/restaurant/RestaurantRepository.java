package model.restaurant;

import model.dishes.Dishes;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findById(Long restaurantId);

    List<Restaurant> findByCategory(Long restaurantId);


    Boolean isOpen(Long restaurantId);

    void rateRestaurant(Long clientId, Long restaurantId, int rate);

    List<Dishes> showRestaurantMenu(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

}
