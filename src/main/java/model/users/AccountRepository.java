package model.users;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(Long cliendId);

    Optional<Account> findByEmail(String email);

    Optional<Account> insert(Client client);


    void updateClientInformation(Client client);

    void updateDeliverInformation(Deliver client);

    void communicateWithDeliver(Long clientId, Long deliverId, String message);




}
