package use_cases.rate;

import model.command.CommandRepository;

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
