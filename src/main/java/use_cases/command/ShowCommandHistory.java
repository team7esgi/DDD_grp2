package use_cases.command;

import model.ObjectId;
import model.command.Command;
import model.command.CommandRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;
import model.users.Client;

import java.util.List;
import java.util.Optional;

public class ShowCommandHistory {

   private final CommandRepository commandRepository;
    private final AccountRepository accountRepository;


    public ShowCommandHistory(CommandRepository commandRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.accountRepository = accountRepository;
    }

    public Optional<List<Command>> execute(ObjectId clientId) throws AccountException {
        Optional<Account> clientExisted = accountRepository.findById(clientId);

        Client.verificationOfClient(clientExisted);

        return commandRepository.getAllCommandsForUser(clientId);
    }

}
