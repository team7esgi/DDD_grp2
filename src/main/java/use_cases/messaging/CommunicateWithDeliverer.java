package use_cases.messaging;

import model.ObjectId;
import model.users.Account;
import model.users.AccountException;
import model.users.AccountRepository;

import java.util.Optional;

import static model.dishes.Dishes.verificationOfDishes;
import static model.users.Client.verificationOfClient;
import static model.users.Deliverer.verificationOfDeliverer;


public class CommunicateWithDeliverer {


    private final AccountRepository accountRepository;

    public CommunicateWithDeliverer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void execute(ObjectId clientId, ObjectId deliverId, String message) throws AccountException {

        Optional<Account> clientExisted = accountRepository.findById(clientId);
        Optional<Account> delivererExisted = accountRepository.findById(deliverId);

        verificationOfClient(clientExisted);
        verificationOfDeliverer(delivererExisted);

        accountRepository.sendMessage(clientId, deliverId, message);

    }

}
