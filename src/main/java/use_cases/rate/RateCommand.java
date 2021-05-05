package use_cases.rate;

import model.Restaurant;
import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.users.Client;

import java.util.List;

public class RateCommand {
    CommandRepository commandRepository;

    void rateCommand(Long commandId, int rate){
        try{
           commandRepository.rateCommand(commandId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
