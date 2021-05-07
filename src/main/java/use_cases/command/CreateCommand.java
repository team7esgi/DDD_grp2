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

import java.util.List;
import java.util.Optional;

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

        Optional<Account> clientAccount = accountRepository.findById(clientId);
        Optional<Restaurant> restaurantFounded = restaurantRepository.findById(restaurantId);
        boolean isOpen = restaurantRepository.isOpen(restaurantId);

        verificationOf(dishesList, clientAccount, restaurantFounded, isOpen);

        return commandRepository.createCommand(dishesList, clientId, restaurantId);
    }


    public void verificationOf(List<Dishes> dishesList, Optional<Account> clientAccount, Optional<Restaurant> restaurantFounded, boolean isOpen) throws AccountException, RestaurantException, CommandException {
        if (!clientAccount.isPresent()) throw new AccountException("Client doesn't exist !");

        if (!restaurantFounded.isPresent()) throw new RestaurantException("No such restaurant !");

        if (!isOpen) throw new RestaurantException("Restaurant closed ! ");

        for (Dishes dish : dishesList) {
            if (!dish.isAvailable()) throw new CommandException("dish not available");
        }
    }

}
