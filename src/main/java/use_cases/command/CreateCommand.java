package use_cases.command;

import model.ObjectId;
import model.command.Command;
import model.command.CommandException;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantException;
import model.restaurant.RestaurantRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;
import model.users.Client;

import java.util.List;
import java.util.Optional;

import static model.dishes.Dishes.verificationOfDishes;
import static model.restaurant.Restaurant.*;
import static model.users.Client.verificationOfClient;

public class CreateCommand {


    private final CommandRepository commandRepository;
    private final RestaurantRepository restaurantRepository;
    private final AccountRepository accountRepository;


    public CreateCommand(CommandRepository commandRepository, RestaurantRepository restaurantRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.restaurantRepository = restaurantRepository;
        this.accountRepository = accountRepository;
    }

    Optional<Command> execute(List<Dishes> dishesList, ObjectId clientId, ObjectId restaurantId) throws CommandException, RestaurantException, AccountException {

        Optional<Account> clientExisted = accountRepository.findById(clientId);
        Optional<Restaurant> restaurantExisted = restaurantRepository.findById(restaurantId);
        boolean isOpen = restaurantRepository.isOpen(restaurantId);

        VerificationOfExistenceAndAvailability(restaurantExisted, isOpen);
        verificationOfClient(clientExisted);
        verificationOfDishes(dishesList);

        return commandRepository.createCommand(dishesList, clientId, restaurantId);
    }


}
