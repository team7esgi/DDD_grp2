package use_cases.rate;

import model.command.CommandException;
import model.command.CommandRepository;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;

import java.util.Optional;

public class RateDeliverer {

    private final CommandRepository commandRepository;
    private final AccountRepository accountRepository;

    public RateDeliverer(CommandRepository commandRepository, AccountRepository accountRepository) {
        this.commandRepository = commandRepository;
        this.accountRepository = accountRepository;
    }

    void rateDeliverer(Long clientId, Long delivererId, int rate) throws Exception {

        Optional<Account> client = accountRepository.findById(clientId);
        if (!client.isPresent()) throw new AccountException("no such user ! ");

        Optional<Account> deliverer = accountRepository.findById(delivererId);
        if (!deliverer.isPresent()) throw new CommandException("no such command ! ");

        if (rate <0 || rate >5) throw new Exception("rate inexistant ! ");

        try{
            commandRepository.rateDeliverer(clientId, delivererId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
