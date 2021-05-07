package use_cases.rate;

import model.ObjectId;
import model.command.Command;
import model.command.CommandException;
import model.command.CommandRepository;
import model.command.CommandState;
import model.dishes.Description;
import model.dishes.Dishes;
import model.maps.Map;
import model.rate.Rate;
import model.restaurant.Restaurant;
import model.users.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RateDelivererTest {

    AccountRepository mockAccountRepository = mock(AccountRepository.class);

    RateDeliverer rateDeliverer;

    Client client = null;
    Deliverer deliver = null;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Name name = new Name("test1", "test2");
        Address address = new Address(12, "street", 75010, "Paris", "France");
        client = new Client("test@mail.com", "password",name,
                address,"0000000000", "des details");

        Map route = new Map(new Address(), new Address());
        deliver = new Deliverer("test@mail.com", "password",new Name("delivererFn", "delivererLn"),
                route,route, new Rate());

        Rate rateCommand = new Rate();
        rateCommand.addRating(5);
        when(mockAccountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(mockAccountRepository.findById(deliver.getId())).thenReturn(Optional.of(client));

        rateDeliverer =  new RateDeliverer(mockAccountRepository);

    }

    @Test
    void rateDeliverer() {
        assertDoesNotThrow(() -> rateDeliverer.execute(client.getId(), deliver.getId(), 5));
    }

    @Test
    void rateDelivererExceptionRate() {
        assertThrows(Exception.class, () -> rateDeliverer.execute(client.getId(), deliver.getId(), 10));
    }

    @Test
    void rateDelivererExceptionClient() {
        assertThrows(AccountException.class, () -> rateDeliverer.execute(new ObjectId(), deliver.getId(), 5));
    }

    @Test
    void rateDelivererExceptionDeliverer() {
        assertThrows(AccountException.class, () -> rateDeliverer.execute(client.getId(), new ObjectId(), 5));
    }
}
