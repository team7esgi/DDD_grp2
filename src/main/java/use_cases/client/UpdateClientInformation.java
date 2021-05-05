package use_cases.client;

import model.users.Account;
import model.users.AccountRepository;
import model.users.Client;

public class UpdateClientInformation {

    AccountRepository accountRepository;

    void updateClientInformation(Client client){

        try{
            accountRepository.updateClientInformation(client);

        }catch (Error error){
            System.err.println(error.getMessage());
        }

    }
}
