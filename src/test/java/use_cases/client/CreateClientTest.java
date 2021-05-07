package use_cases.client;

import model.users.*;

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
    private static Address clientAddress = null;
    private static Name clientName = null;

    @BeforeEach
    public void setUp() {

        clientName = new Name("clientFirstName", "clientLastName");
        clientAddress = new Address(1, "rue de Paris", 75001, "Paris", "France");
        client = new Client("client@mail.com","000000",clientName, clientAddress, "0000000000","details");
        when(accountRepository.insert(client)).thenReturn(Optional.of(client));

    }

    @Test
    public void execute() {
        //
        Optional<Account> newClient = accountRepository.insert(client);
        assertNotNull(newClient.get());
        System.out.println(newClient.toString());
        assertEquals(client, newClient.get());

    }

}
