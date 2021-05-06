package use_cases.client;

import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;
import model.users.Client;

import java.util.Optional;

public class CreateClient {


    private final AccountRepository accountRepository;

    public CreateClient(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Client client) throws AccountException {
        Optional<Account> clientFounded = accountRepository.findByEmail(client.getEmail());
        if(clientFounded.isPresent()) throw new AccountException("User already exist !");
        accountRepository.insert(client);



    }
}
