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

    void updateClientInformation(Client client){
        Optional<Account> clientFounded = accountRepository.findById(client.getId());
        try{
            if(!clientFounded.isPresent()) throw new AccountException("Client non existant !");
            accountRepository.updateClientInformation(client);

        }catch (Error | Exception error){
            System.err.println(error.getMessage());
        }

    }
}
