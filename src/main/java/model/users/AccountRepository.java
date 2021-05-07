package model.users;

import model.ObjectId;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(ObjectId clientId);

    Optional<Account> findByEmail(String email);

    Optional<Account> insert(Client client);

    void rateDeliverer(int rate, ObjectId delivererId, ObjectId clientId);

    void updateClientInformation(Client client);

    void updateDeliverInformation(Deliverer client);

    void sendMessage(ObjectId senderId, ObjectId receiverId, String message);




}
