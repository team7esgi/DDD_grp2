package use_cases.client;

import model.users.Account;
import model.users.AccountRepository;
import model.users.Client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


public class CreateClientTest {

    private static AccountRepository accountRepository = mock(AccountRepository.class);
    private static Client client = null;
    private static Client newClient = null;

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
        when(accountRepository.insert(client)).thenReturn(Optional.of(client));

    }

    @Test
    public void execute() {

        Optional<Account> newClient = accountRepository.insert(client);
        assertNotNull(newClient.get());
        System.out.println(newClient.toString());
        assertEquals(client, newClient.get());

    }

}
