package use_cases.messaging;

import model.users.AccountException;
import model.users.AccountRepository;

public class CommunicateWithDeliverer {

    private final AccountRepository accountRepository;

    public CommunicateWithDeliverer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void communicateWithDeliver(Long clientId, Long deliverId, String message){
        try{
            if(!accountRepository.findById(clientId).isPresent()) throw new AccountException("No such user ! ");
            if(!accountRepository.findById(deliverId).isPresent()) throw new AccountException("No such deliverer !");
            accountRepository.communicateWithDeliver(clientId, deliverId, message);
        }catch (Error | Exception error){
            System.err.println(error);

        }
    }
}
