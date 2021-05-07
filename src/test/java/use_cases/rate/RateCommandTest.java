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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class RateCommandTest {

    AccountRepository mockAccountRepository = mock(AccountRepository.class);
    CommandRepository mockCommandRepository = mock(CommandRepository.class);

    RateCommand rateCommandUseCase;

    Client client = null;
    Command command = null;
    Dishes dish = null;
    List<Dishes> dishesList = new ArrayList<Dishes>();
    Deliverer deliver = null;
    Restaurant restaurant = null;
    ObjectId commandId = null;

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
            dish = new Dishes(objectId, description, restaurantId, rateDish, true);//(objectId,description, restaurantId, rateDish, true);
            dishesList.add(dish);
        }

        ObjectId objectId = new ObjectId();
        Rate rateRestau = new Rate();
        restaurant = new Restaurant("test1@test.com", "password", "restau1",
                "chinois", address, dishesList, true, rateRestau);

        Rate rateDelivrer = new Rate();
        Map position = new Map(address, address);
        Map route = new Map(address, address);
        deliver = new Deliverer("test2@test.com", "password", name, position, route, rateDelivrer) ;
        CommandState state = CommandState.DELIVERED;

        commandId = new ObjectId();
        Rate rateCommand = new Rate();
        rateCommand.addRating(5);
        command = new Command(commandId,dishesList, client.getId(),deliver.getId(),position,state, rateCommand);
        when(mockCommandRepository.createCommand(dishesList, client.getId(), command.getId())).thenReturn(Optional.of(command));
        when(mockAccountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(mockCommandRepository.findById(command.getId())).thenReturn(Optional.of(command));

        rateCommandUseCase =  new RateCommand(mockCommandRepository, mockAccountRepository);

    }

    @Test
    void rateCommand() {
        Command ratedCommand = null;
        try {
            ratedCommand = rateCommandUseCase.execute(client.getId(), command.getId(), 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(5.0, ratedCommand.getRate().getRatings());

        assertNotNull(ratedCommand);
        assertEquals(commandId, ratedCommand.getId());
        assertEquals(client.getId(), ratedCommand.getClientId());
        assertEquals(CommandState.DELIVERED, ratedCommand.getState());

    }


    @Test
    void rateCommandExceptionRate() {
        assertThrows(Exception.class, () -> rateCommandUseCase.execute(client.getId(), command.getId(), 10));
    }

    @Test
    void rateCommandExceptionUser() {
        assertThrows(AccountException.class, () -> rateCommandUseCase.execute(new ObjectId(), command.getId(), 5));
    }

    @Test
    void rateCommandExceptionCommand() {
        assertThrows(CommandException.class, () -> rateCommandUseCase.execute(client.getId(), new ObjectId(), 5));
    }
}
