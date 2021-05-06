package use_cases.client;

import model.users.AccountRepository;
import model.users.Client;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreateClientTest {

    AccountRepository accountRepository = mock(AccountRepository.class);
    Client client = null;
    Client newClient = null;
    @BeforeEach
    public void setUp() {

        client = new Client(0L,"test@mail.com", "0000",
                "test","test", "address",
                "0000000000", "des details");
        newClient = new Client(0L,"test@mail.com", "0000",
                "test","test", "address",
                "0000000000", "des details");
        newClient = new Client(0L,"test@mail.com", "0000",
                "test","test", "address",
                "0000000000", "des details");

    }

    @Test
    public void execute() {
        when(accountRepository.insert(client)).thenReturn(Optional.of(client));
        Assertions.assertTrue(client.equals(newClient));

        //TODO: S'assurer que le client ne soit pas le même
        newClient.setDetails("details faux");
        Assertions.assertFalse(client.equals(newClient));

    }

}
