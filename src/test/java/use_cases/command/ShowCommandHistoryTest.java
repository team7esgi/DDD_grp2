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
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ShowCommandHistoryTest {

    private static CommandRepository mockCommandRepository = mock(CommandRepository.class);;

    private static RestaurantRepository mockRestaurantRepository = mock(RestaurantRepository.class);
    private static AccountRepository mockAccountRepository = mock(AccountRepository.class);


    List<Dishes> dishesList = new ArrayList<Dishes>();
    List<Command> commandList = new ArrayList<Command>();
    Client client = new Client();
    Deliver deliver = new Deliver();
    Restaurant restaurant = new Restaurant();
    Command command = new Command();
    Command command2 = new Command();
    Dishes dishe = new Dishes();

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
        CommandState state = CommandState.DELIVERED;
        command = new Command(0L,dishesList, client.getId(),deliver.getId(),map,state);
        command2 = new Command(1L,dishesList, client.getId(),deliver.getId(),map,state);
        commandList.add(command);
        commandList.add(command2);
        when(mockAccountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(mockRestaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));
        when(mockCommandRepository.getAllCommandsForUser(client.getId())).thenReturn(Optional.of(commandList));
    }

    @Test
    void getCommandHistory() {
        Optional<List<Command>> newCommandList = mockCommandRepository.getAllCommandsForUser(0L);
        assertNotNull(newCommandList);
        assertEquals(2, newCommandList.get().size());
        assertEquals(0L, newCommandList.get().get(0).getId());
        assertEquals(1L, newCommandList.get().get(1).getId());

    }
}
