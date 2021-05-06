package use_cases.messaging;

import model.ObjectId;
import model.users.AccountException;
import model.users.AccountRepository;

public class CommunicateWithDeliverer {


    private final AccountRepository accountRepository;

    public CommunicateWithDeliverer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void execute(ObjectId clientId, ObjectId deliverId, String message) throws AccountException {

        boolean isClientPresent = accountRepository.findById(clientId).isPresent();
        boolean isDelivererPresent = accountRepository.findById(deliverId).isPresent();

        verificationOf(isClientPresent, isDelivererPresent);

        accountRepository.sendMessage(clientId, deliverId, message);

    }

    private void verificationOf(boolean isClientPresent, boolean isDelivererPresent) throws AccountException {
        if(!isClientPresent) throw new AccountException("No such user ! ");
        if(!isDelivererPresent) throw new AccountException("No such deliverer !");
    }
}
