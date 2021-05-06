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
        List<Dishes> restaurantMenu = new ArrayList<Dishes>();

        try{
           restaurantMenu = restaurantRepository.showRestaurantMenu(restaurant);
        }catch (Error error){
            System.err.println(error.getMessage());
        }

        return  restaurantMenu;
    }
}
