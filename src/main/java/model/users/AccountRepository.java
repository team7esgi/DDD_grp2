package model.users;

import model.ObjectId;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(ObjectId cliendId);

    Optional<Account> findByEmail(String email);

    Optional<Account> insert(Client client);

    void rateDeliverer(int rate, ObjectId delivererId, ObjectId clientId);

    void updateClientInformation(Client client);

    void updateDeliverInformation(Deliverer client);

    void communicateWithDeliver(ObjectId clientId, ObjectId deliverId, String message);





}
