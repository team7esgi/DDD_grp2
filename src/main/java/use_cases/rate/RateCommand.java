package use_cases.rate;

import model.command.CommandRepository;
import model.users.AccountRepository;

public class RateCommand {

    private final CommandRepository commandRepository;
    private final AccountRepository accountRepository;

    public RateCommand(CommandRepository commandRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.accountRepository = accountRepository;
    }

    void rateCommand(Long cliendId, Long commandId, int rate){
        if ()
        try{
           commandRepository.rateCommand(commandId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
