package use_cases.rate;

import model.command.CommandRepository;

public class RateRestaurant {
    CommandRepository commandRepository;

    void rateRestaurant(Long restaurantId, int rate){
        try{
            commandRepository.rateRestaurant(restaurantId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
