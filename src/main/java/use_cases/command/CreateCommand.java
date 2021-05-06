package use_cases.command;

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

    Optional<Command> createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant) throws Exception {

        Optional<Command> command = null;
        Optional<Account> clientAccount = accountRepository.findById(client.getId());
        if(!clientAccount.isPresent()) throw new AccountException("Client doesn't exist !");

        Optional<Restaurant> restaurantFounded = restaurantRepository.findById(restaurant.getId());
        if(!restaurantFounded.isPresent()) throw new RestaurantException("No such restaurant !");

        boolean isOpen = restaurantRepository.isOpen(restaurant.getId());
        if(!isOpen) throw new RestaurantException("Restaurant closed ! ");

        try{

            command = commandRepository.createCommand(dishesList,client, restaurant);

        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return command;
    }
}
