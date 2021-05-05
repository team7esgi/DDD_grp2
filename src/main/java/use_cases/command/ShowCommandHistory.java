package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;

import java.util.List;
import java.util.Optional;

public class ShowCommandHistory {

   private final CommandRepository commandRepository;
    private final AccountRepository accountRepository;


    public ShowCommandHistory(CommandRepository commandRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.accountRepository = accountRepository;
    }

    public Optional<List<Command>> getCommandHistory(Long clientId) throws AccountException {
        Optional<Account> clientFounded = accountRepository.findById(clientId);

        if(!clientFounded.isPresent()) throw new AccountException("No such user !");

        return commandRepository.getAllCommandsForUser(clientId);
    }

}
