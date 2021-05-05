package use_cases.command;

import model.restaurant.Restaurant;
import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.users.Client;

import java.util.List;
import java.util.Optional;

public class CreateCommand {

    CommandRepository commandRepository;

    Command createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant){
        Optional<Command> command = Optional.of(new Command());
        try{

            command = commandRepository.createCommand(dishesList,client, restaurant);

        }catch (Error error){
            System.err.println(error.getMessage());
        }
        return command;
    }
}
