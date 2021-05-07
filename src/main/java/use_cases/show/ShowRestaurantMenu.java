package use_cases.show;

import model.dishes.Dishes;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class ShowRestaurantMenu {

    private final RestaurantRepository restaurantRepository;

    public ShowRestaurantMenu(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    List<Dishes> execute(Restaurant restaurant){

        return restaurantRepository.showRestaurantMenu(restaurant);
    }
}
