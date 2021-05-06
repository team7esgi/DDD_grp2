package use_cases.rate;

import model.ObjectId;
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

    void execute(ObjectId clientId, ObjectId commandId, int rate) throws Exception {

        Optional<Command> command = commandRepository.findById(commandId);
        Optional<Account> client = accountRepository.findById(clientId);
        commandRepository.rateCommand(clientId, commandId, rate);

        verificationOf(rate, command, client);

    }

    private void verificationOf(int rate, Optional<Command> command, Optional<Account> client) throws Exception {
        if (!client.isPresent()) throw new AccountException("no such user ! ");
        if (!command.isPresent()) throw new CommandException("no such command ! ");
        if (rate <0 || rate >5) throw new Exception("rate inexistant ! ");
    }
}
