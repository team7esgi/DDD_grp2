package model.users;

public interface AccountRepository {
    Account findById(Long cliendId);

    void updateClientInformation(Client client);

    void updateDeliverInformation(Deliver client);

    void communicateWithDeliver(Client client, Deliver deliver, String message);





}
