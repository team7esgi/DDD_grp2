package use_cases.rate;

import model.command.Command;
import model.command.CommandException;
import model.command.CommandRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;

import java.util.Optional;

public class RateCommand {


    private final CommandRepository commandRepository;
    private final AccountRepository accountRepository;

    public RateCommand(CommandRepository commandRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.accountRepository = accountRepository;
    }

    void rateCommand(Long clientId, Long commandId, int rate) throws Exception {

        Optional<Account> client = accountRepository.findById(clientId);
        if (!client.isPresent()) throw new AccountException("no such user ! ");

        Optional<Command> command = commandRepository.findById(commandId);
        if (!command.isPresent()) throw new CommandException("no such command ! ");

        if (rate <0 || rate >5) throw new Exception("rate inexistant ! ");

        try{
           commandRepository.rateCommand(clientId, commandId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
