package use_cases.rate;

import model.ObjectId;
import model.command.Command;
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

class RateCommandTest {

    AccountRepository mockAccountRepository = mock(AccountRepository.class);
    CommandRepository mockCommandeRepository = mock(CommandRepository.class);
    Client client = null;
    Command command = null;
    Dishes dishe = null;
    List<Dishes> dishesList = new ArrayList<Dishes>();
    Deliverer deliver = null;
    Restaurant restaurant = null;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Name name = new Name("test1", "test2");
        Address address = new Address(12, "street", 75010, "Paris", "France");
        client = new Client("test@mail.com", "password",name,
                address,"0000000000", "des details");

        //Dishe List
        for(int i = 0; i<3; i++){
            ObjectId objectId = new ObjectId();
            ObjectId restaurantId = new ObjectId();
            Description description = new Description("descriptDish", "plat_"+i, 14);
            Rate rateDish = new Rate();
            dishe = new Dishes(objectId, description, restaurantId, rateDish, true);//(objectId,description, restaurantId, rateDish, true);
            dishesList.add(dishe);
        }

        ObjectId objectId = new ObjectId();
        Rate rateRestau = new Rate();
        restaurant = new Restaurant("test1@test.com", "password", objectId, "restau1",
                "chinois", address, dishesList, true, rateRestau);


        Rate rateDelivrer = new Rate();
        Map position = new Map(address, address);
        Map route = new Map(address, address);
        deliver = new Deliverer("test2@test.com", "password", name, position, route, rateDelivrer) ;
        CommandState state = CommandState.DELIVERED;

        ObjectId commandId = new ObjectId();
        command = new Command(commandId,dishesList, client.getId(),deliver.getId(),position,state);

        when(mockAccountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(mockCommandeRepository.findById(client.getId())).thenReturn(Optional.of(command));
    }

    @Test
    void rateCommand() {
        mockCommandeRepository.rateCommand(client.getId(), command.getId(), 5);
        Command ratedCommand = mockCommandeRepository.findById(client.getId()).get();
        assertNotNull(ratedCommand);
        assertEquals(0L, command.getId());
        assertEquals(0L, command.getClientId());
        assertEquals(0L, command.getDelivererId());
    }
}
