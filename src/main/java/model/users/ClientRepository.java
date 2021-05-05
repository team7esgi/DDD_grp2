package model.users;

import java.util.Optional;

public interface ClientRepository {

    Boolean clientExist(Client client);
}
