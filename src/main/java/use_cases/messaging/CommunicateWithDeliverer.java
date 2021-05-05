package use_cases.messaging;

import model.users.AccountRepository;
import model.users.Client;
import model.users.Deliver;

public class CommunicateWithDeliverer {

    private final AccountRepository accountRepository;

    public CommunicateWithDeliverer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void commnunicateWithDeliver(Long clientId, Long deliverId, String message){
        try{
            if(accountRepository.findById(clientId).isEmpty()) throw new Exception("Client non existant");
            if(accountRepository.findById(deliverId).isEmpty()) throw new Exception("Deliver non existant");
            accountRepository.communicateWithDeliver(clientId, deliverId, message);
        }catch (Error | Exception error){
            System.err.println(error);

        }
    }
}
