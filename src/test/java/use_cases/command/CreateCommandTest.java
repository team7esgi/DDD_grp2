package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;
import model.dishes.Dishes;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantRepository;
import model.users.AccountRepository;
import model.users.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateCommandTest {


    CommandRepository commandRepository = mock(CommandRepository.class);
    RestaurantRepository restaurantRepository = mock(RestaurantRepository.class);
    AccountRepository accountRepository = mock(AccountRepository.class);

    List<Dishes> dishesList = new ArrayList<Dishes>();
    Client client = new Client();
    Restaurant restaurant = new Restaurant();
    Command command = new Command();
    Dishes dishe = new Dishes();
    @BeforeEach
    void setUp() {


        client = new Client(0L,"test@mail.com", "0000",
                "test","test", "address",
                "0000000000", "des details");
        //Dishe List
        for(int i = 0; i<3; i++){
            dishe = new Dishes(1L,"plat_"+i,"details",(float) i,1L,true);
            dishesList.add(dishe);
        }

        //Restaurant
        restaurant = new Restaurant(1L,true,"monRestaurant","japonais","1 rue de Paris", dishesList, true);


    }

    @Test
    void createCommand() {
        when(accountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(restaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));
        System.out.println(client.toString());
        when(commandRepository.createCommand(dishesList, client, restaurant)).thenReturn(Optional.of(command));

        System.out.println(command.toString());
    }
}
