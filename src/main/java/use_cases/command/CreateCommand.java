package use_cases.command;

import model.ObjectId;
import model.command.CommandException;
import model.restaurant.Restaurant;
import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.restaurant.RestaurantException;
import model.restaurant.RestaurantRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;
import model.users.Client;

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

    Optional<Command> execute(List<Dishes> dishesList, ObjectId clientId, ObjectId restaurantId) throws Exception {

        Optional<Command> command = null;
        Optional<Account> clientAccount = accountRepository.findById(clientId);
        if(!clientAccount.isPresent()) throw new AccountException("Client doesn't exist !");

        Optional<Restaurant> restaurantFounded = restaurantRepository.findById(restaurantId);
        if(!restaurantFounded.isPresent()) throw new RestaurantException("No such restaurant !");

        boolean isOpen = restaurantRepository.isOpen(restaurantId);
        if(!isOpen) throw new RestaurantException("Restaurant closed ! ");

        for(Dishes dish : dishesList) {
            if(!dish.isAvailable()) throw new CommandException("dish not available");
        }
        try{

            command = commandRepository.createCommand(dishesList,clientId, restaurantId);

        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return command;
    }
}
