package use_cases.messaging;

import model.users.AccountRepository;

public class CommunicateWithDeliverer {

    private final AccountRepository accountRepository;

    public CommunicateWithDeliverer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void communicateWithDeliver(Long clientId, Long deliverId, String message){
        try{
            if(!accountRepository.findById(clientId).isPresent()) throw new Exception("Client non existant");
            if(!accountRepository.findById(deliverId).isPresent()) throw new Exception("Deliver non existant");
            accountRepository.communicateWithDeliver(clientId, deliverId, message);
        }catch (Error | Exception error){
            System.err.println(error);

        }
    }
}
