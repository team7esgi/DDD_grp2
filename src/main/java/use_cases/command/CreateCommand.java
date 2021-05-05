package use_cases.command;

import model.dishes.DishesRepository;
import model.restaurant.Restaurant;
import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.restaurant.RestaurantRepository;
import model.users.Client;

import java.util.List;

public class CreateCommand {

    CommandRepository commandRepository;
    DishesRepository dishesRepository;
    RestaurantRepository restaurantRepository;


    public CreateCommand(CommandRepository commandRepository, DishesRepository dishesRepository, RestaurantRepository restaurantRepository) {
        this.commandRepository = commandRepository;
        this.dishesRepository = dishesRepository;
        this.restaurantRepository = restaurantRepository;
    }

    Command createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant){
        Command command = new Command();
        try{
            if(clie)
            command = commandRepository.createCommand(dishesList,client, restaurant);

        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return command;
    }
}
