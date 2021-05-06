package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;
import model.command.CommandState;
import model.dishes.Dishes;
import model.maps.Map;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantRepository;
import model.users.AccountRepository;
import model.users.Client;
import model.users.Deliver;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class CreateCommandTest {


    private static CommandRepository mockCommandRepository = mock(CommandRepository.class);;

    private static RestaurantRepository mockRestaurantRepository = mock(RestaurantRepository.class);
    private static AccountRepository mockAccountRepository = mock(AccountRepository.class);

    private static List<Dishes> dishesList = new ArrayList<Dishes>();
    private static Client client = new Client();
    private static Deliver deliver = new Deliver();
    private static Restaurant restaurant = new Restaurant();
    private static Command command = new Command();
    private static Dishes dishe = new Dishes();

    @BeforeEach
    public void setUp() {


        client = new Client(0L,"test@mail.com", "0000",
                "test","test", "1 Rue de Paris",
                "0000000000", "des details");


        //Dishe List
        for(int i = 0; i<3; i++){
            dishe = new Dishes(0L,"plat_"+i,"details",(float) i,1L,true);
            dishesList.add(dishe);
        }


        //Restaurant
        restaurant = new Restaurant(0L,true,"monRestaurant","japonais","1 rue de Marseille", dishesList, true);
        Map map = new Map(restaurant.getAddress(), client.getAddress());
        deliver = new Deliver(0L,map , map) ;
        CommandState state = CommandState.ACCEPTED;
        command = new Command(0L,dishesList, client.getId(),deliver.getId(),map,state);

        when(mockAccountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(mockRestaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));
        when(mockCommandRepository.createCommand(dishesList, client, restaurant)).thenReturn(Optional.of(command));
    }

    @Test
    void createCommand() {

        Optional<Command> newCommand = mockCommandRepository.createCommand(dishesList,client,restaurant);
        assertNotNull(newCommand.get());
        assertEquals(0L, newCommand.get().getId() );
        assertEquals(0L, newCommand.get().getClientId());
        assertEquals(0L, newCommand.get().getDelivererId());
        assertEquals(dishesList,newCommand.get().getDishesList());


    }
}
