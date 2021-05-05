package use_cases.command;

import model.restaurant.Restaurant;
import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.restaurant.RestaurantRepository;
import model.users.Client;

import java.util.List;
import java.util.Optional;

public class CreateCommand {

    private final CommandRepository commandRepository;
    private final RestaurantRepository restaurantRepository;


    public CreateCommand(CommandRepository commandRepository, RestaurantRepository restaurantRepository) {
        this.commandRepository = commandRepository;
        this.restaurantRepository = restaurantRepository;
    }

    Optional<Command> createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant) throws Exception {

        Optional<Command> command = null;

        Optional<Restaurant> restaurantFounded = restaurantRepository.findById(restaurant.getId());
        if(!restaurantFounded.isPresent()) throw new Exception("No such restaurant !");

        boolean isOpen = restaurantRepository.isOpen(restaurant.getId());
        if(!isOpen) throw new Exception("Restaurant closed ! ");

        try{

            command = commandRepository.createCommand(dishesList,client, restaurant);

        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return command;
    }
}
