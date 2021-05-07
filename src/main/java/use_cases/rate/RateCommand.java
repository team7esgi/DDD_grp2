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

    Command execute(ObjectId clientId, ObjectId commandId, int rate) throws Exception {

        Optional<Command> command = commandRepository.findById(commandId);
        Optional<Account> client = accountRepository.findById(clientId);

        verificationOf(rate, command, client);

        Command ratedCommand = command.get();
        ratedCommand.getRate().addRating(rate);

        commandRepository.save(ratedCommand);
        return ratedCommand;
    }



    private void verificationOf(int rate, Optional<Command> command, Optional<Account> client) throws Exception {
        try{
            if (!client.isPresent()) throw new AccountException("no such user ! ");
        }catch (NullPointerException e){
            throw new AccountException("no such user ! ");
        }
        try{
            if (!command.isPresent()) throw new CommandException("no such command ! ");
        }catch (NullPointerException e){
            throw new CommandException("no such command ! ");
        }

        if (!(rate > 0 && rate <= 5)) {
            throw new Exception("rate inexistant ! ");
        }
    }
}
