package use_cases.show;

import model.dishes.Dishes;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class ShowRestaurantsAvailable {
    private final RestaurantRepository restaurantRepository;

    public ShowRestaurantsAvailable(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    List<Restaurant> showRestaurantsAvailable(){
        List<Restaurant> restaurantsAvaible = new ArrayList<Restaurant>();
        try{
            List<Restaurant> restaurants = restaurantRepository.getAllRestaurants();
            for (Restaurant restaurant: restaurants) {
                if (restaurant.isAvailable()) restaurantsAvaible.add(restaurant);
            }
        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return  restaurantsAvaible;
    }
}
