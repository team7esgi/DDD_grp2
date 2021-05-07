package use_cases.client;

import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;
import model.users.Client;

import java.util.Optional;

import static model.users.Client.verificationOfClient;

public class CreateClient {


    private final AccountRepository accountRepository;

    public CreateClient(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Client execute(Client client) throws AccountException {
        Optional<Account> clientFounded = accountRepository.findByEmail(client.getEmail());

        verificationOfClient(clientFounded);

        accountRepository.insert(client);
        return client;
    }

}
