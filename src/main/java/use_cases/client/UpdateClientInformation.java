package use_cases.client;

import model.users.AccountRepository;
import model.users.Client;

public class UpdateClientInformation {

    private final AccountRepository accountRepository;

    public UpdateClientInformation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void updateClientInformation(Client client){

        try{
            if(accountRepository.findById(client.getId()).isEmpty()) throw new Exception("Client non existant !");
            accountRepository.updateClientInformation(client);

        }catch (Error | Exception error){
            System.err.println(error.getMessage());
        }

    }
}
