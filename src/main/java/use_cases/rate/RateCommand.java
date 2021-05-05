package use_cases.rate;

import model.command.Command;
import model.command.CommandRepository;
import model.users.Account;
import model.users.AccountRepository;

import java.util.Optional;

public class RateCommand {

    private final CommandRepository commandRepository;
    private final AccountRepository accountRepository;

    public RateCommand(CommandRepository commandRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.accountRepository = accountRepository;
    }

    void rateCommand(Long cliendId, Long commandId, int rate) throws Exception {
        Optional<Account> client = accountRepository.findById(cliendId);
        if (!client.isPresent()) throw new Exception("no such user ! ");
        Optional<Command> command = commandRepository.findById(commandId);
        if (!command.isPresent()) throw new Exception("no such command ! ");
        if (rate <0 || rate >5) throw new Exception("rate inexistant ! ");

        try{
           commandRepository.rateCommand(cliendId, commandId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
