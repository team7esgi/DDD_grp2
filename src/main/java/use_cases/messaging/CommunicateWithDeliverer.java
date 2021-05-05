package use_cases.messaging;

import model.users.AccountRepository;
import model.users.Client;
import model.users.Deliver;

public class CommunicateWithDeliverer {

    AccountRepository accountRepository;

    void commnunicateWithDeliver(Client client, Deliver deliver, String message){
        try{
            accountRepository.communicateWithDeliver(client, deliver, message);
        }catch (Error error){
            System.err.println(error);

        }
    }
}
