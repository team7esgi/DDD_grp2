package model.restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findById(Long restaurantId);

    Boolean isOpen(Long restaurantId);

    void rateRestaurant(Long clientId, Long restaurantId, int rate);

}
