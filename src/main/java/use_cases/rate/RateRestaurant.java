package use_cases.rate;

import model.ObjectId;
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

    public RateRestaurant(RestaurantRepository restaurantRepository, AccountRepository accountRepository) {
        this.restaurantRepository = restaurantRepository;
        this.accountRepository = accountRepository;
    }


    void execute(ObjectId clientId, ObjectId restaurantId, int rate) throws Exception {
        Optional<Account> client = accountRepository.findById(clientId);
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        restaurantRepository.rateRestaurant(clientId,restaurantId, rate);

        verificationOf(rate, client, restaurant);

    }

    private void verificationOf(int rate, Optional<Account> client, Optional<Restaurant> restaurant) throws Exception {
        if (!client.isPresent()) throw new AccountException("no such user !");
        if (!restaurant.isPresent()) throw new RestaurantException("no such restaurant ! ");
        if (rate <0 || rate >5) throw new Exception("rate inexistant ! ");
    }
}
