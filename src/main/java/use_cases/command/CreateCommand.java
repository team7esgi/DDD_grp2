package use_cases.command;

import model.Restaurant;
import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.dishes.DishesRepository;
import model.users.Client;

import java.util.List;


public class CreateCommand {
    CommandRepository commandRepository;

    Command createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant){

        Command command = new Command();
        try{
            command = commandRepository.createCommand(dishesList,client, restaurant);

        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return command;
    }
}
