package use_cases.command;

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
import model.restaurant.RestaurantException;
import model.restaurant.RestaurantRepository;
import model.users.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CreateCommandTest {

    private static AccountRepository accountRepository = mock(AccountRepository.class);
    private static RestaurantRepository restaurantRepository = mock(RestaurantRepository.class);
    private static CommandRepository commandRepository = mock(CommandRepository.class);
    private static CreateCommand createCommandMock = mock(CreateCommand.class);


    private static Client client = null;
    private static Name clientName = null;

    private Deliverer deliverer = null;
    private static Rate rateDeliver;
    private static Name nameDeliver;
    private static Map mapDeliver ;

    private static Restaurant restaurant;
    private static Address restaruantAddress;
    private static Rate rateRestaurant;


    private static List<Dishes> dishesList = new ArrayList<>() ;
    private static Dishes dishe ;
    private static Description description ;
    private static Rate rate;

    private static Command commandClient ;
    private static Map mapCommand;
    private static CommandState stateCommand ;


    @BeforeEach
    void setUp() throws RestaurantException, CommandException, AccountException {

        clientName = new Name("clientFirstName", "clientLastName");
        Address clientAddress = new Address(1, "rue de Paris", 75001, "Paris", "France");
        client = new Client("client@mail.com","000000",clientName, clientAddress, "0000000000","details");

        restaruantAddress = new Address(1,"rue de Marseille",75002,"Paris","France");
        rateRestaurant = new Rate();


        restaurant = new Restaurant("restaurant","000000","Chez Okinawa", "Japonais", restaruantAddress, dishesList,true, rateRestaurant);
        for(int i = 0; i<3; i++){
            description = new Description("plat_"+i,"details",(float)i*10);
            rate = new Rate();
            rate.addRating(i+1);
            dishe = new Dishes(new ObjectId(),description,restaurant.getId(),rate,true);
            dishesList.add(dishe);
        }
        rateRestaurant.addRating(10);
        client = new Client("client@mail.com","000000",clientName, clientAddress, "0000000000","details");

        deliverer = new Deliverer("deliver@mail.com","000000",nameDeliver, mapDeliver, mapDeliver, rateDeliver);
        rateDeliver = new Rate();
        rateDeliver.addRating(7);
        nameDeliver = new Name("ESCOBAR", "Pablo");
        mapDeliver = new Map(restaruantAddress, clientAddress);

        stateCommand = CommandState.ACCEPTED;
        //Dishe List


        commandClient = new Command(new ObjectId(),dishesList,client.getId(),deliverer.getId(), mapCommand, stateCommand,new Rate() );

        when(accountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(restaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));
        when(commandRepository.createCommand(dishesList,client.getId(),restaurant.getId())).thenReturn(Optional.of(commandClient));


        when(createCommandMock.execute(dishesList,client.getId(),restaurant.getId())).thenReturn(Optional.of(commandClient));
        when(createCommandMock.execute(null,client.getId(),restaurant.getId())).thenThrow(new CommandException("Erreur de commande"));
        when(createCommandMock.execute(dishesList,null,restaurant.getId())).thenThrow(new AccountException("Erreur de commande"));
        when(createCommandMock.execute(dishesList,client.getId(),null)).thenThrow(new RestaurantException("Erreur de commande"));



    }

    @Test
    void execute() throws RestaurantException, CommandException, AccountException {
        Optional<Account> newAccount = accountRepository.findById(client.getId());
        Optional<Restaurant> newRestaurant = restaurantRepository.findById(restaurant.getId());
        Optional<Command> newCommand = commandRepository.createCommand(dishesList,client.getId(),restaurant.getId());

        Optional<Command> newCommandmock = createCommandMock.execute(dishesList,client.getId(),restaurant.getId());

        assertNotNull(newAccount.get());
        assertNotNull(newRestaurant.get());
        assertNotNull(newCommand.get());

        assertEquals(commandClient, newCommandmock.get());
        assertEquals(client, newAccount.get());
        assertEquals(restaurant, newRestaurant.get());
        assertEquals(commandClient, newCommand.get());

        assertThrows(CommandException.class,  () ->  createCommandMock.execute(null,client.getId(), restaurant.getId()));
        assertThrows(AccountException.class,  () -> createCommandMock.execute(dishesList,null, restaurant.getId()));
        assertThrows(RestaurantException.class,  () -> createCommandMock.execute(dishesList,client.getId(), null));


    }

    @Test
    void verificationOf() {

    }
}
