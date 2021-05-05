package use_cases.rate;

import model.command.CommandRepository;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantException;
import model.restaurant.RestaurantRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;

import java.util.Optional;

public class RateRestaurant {
    private final RestaurantRepository restaurantRepository;
    private final AccountRepository accountRepository;

    public RateRestaurant(CommandRepository commandRepository, RestaurantRepository restaurantRepository, AccountRepository accountRepository) {
        this.restaurantRepository = restaurantRepository;
        this.accountRepository = accountRepository;
    }


    void rateRestaurant(Long clientId, Long restaurantId, int rate) throws Exception {
        Optional<Account> client = accountRepository.findById(clientId);
        if (!client.isPresent()) throw new AccountException("no such user ! ");

        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (!restaurant.isPresent()) throw new RestaurantException("no such restaurant ! ");

        if (rate <0 || rate >5) throw new Exception("rate inexistant ! ");

        try{
            restaurantRepository.rateRestaurant(clientId,restaurantId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
