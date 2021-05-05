package model.restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findById(Long restaurantId);

    Boolean isOpen(Long restaurantId);
}
