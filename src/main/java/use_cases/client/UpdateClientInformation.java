package use_cases.client;

import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;
import model.users.Client;

import java.util.Optional;

public class UpdateClientInformation {


    private final AccountRepository accountRepository;

    public UpdateClientInformation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void execute(Client client) throws AccountException {
        Optional<Account> clientFounded = accountRepository.findById(client.getId());

        if(!clientFounded.isPresent()) throw new AccountException("Client doesn't exist!");

        accountRepository.updateClientInformation(client);
    }
}
