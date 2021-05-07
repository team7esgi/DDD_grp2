package use_cases.client;

import model.users.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CreateClientTest {

    private static AccountRepository accountRepository = mock(AccountRepository.class);
    private static CreateClient createClientMock = mock(CreateClient.class);

    private static Client client = null;
    private static Address clientAddress = null;
    private static Name clientName = null;

    @BeforeEach
    public void setUp() throws AccountException {

        clientName = new Name("clientFirstName", "clientLastName");
        clientAddress = new Address(1, "rue de Paris", 75001, "Paris", "France");
        client = new Client("client@mail.com","000000",clientName, clientAddress, "0000000000","details");
        when(accountRepository.insert(client)).thenReturn(Optional.of(client));

        when(createClientMock.execute(client)).thenReturn(client);
        when(createClientMock.execute(null)).thenThrow(new AccountException("Compte inexsitant"));


    }

    @Test
    public void execute() throws AccountException {

        Optional<Account> newClient = accountRepository.insert(client);
        assertNotNull(newClient.get());
        assertEquals(client, newClient.get());

        Client clientToInsert = createClientMock.execute(client);
        assertNotNull(clientToInsert);
        assertEquals(client, clientToInsert);
        assertThrows(AccountException.class,()-> createClientMock.execute(null));

    }



}
