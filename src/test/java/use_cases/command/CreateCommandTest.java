package use_cases.command;

import model.ObjectId;
import model.command.Command;
import model.dishes.Description;
import model.dishes.Dishes;
import model.rate.Rate;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantRepository;
import model.users.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateCommandTest {

    private static AccountRepository accountRepository = mock(AccountRepository.class);
    private static RestaurantRepository restaurantRepository = mock(RestaurantRepository.class);
    //private static AccountRepository accountRepository = mock(AccountRepository.class);

    private static Client client = null;
    private static Address clientAddress = null;
    private static Name clientName = null;

    private Deliverer deliverer = null;
    private static Rate rateDeliver = null;
    private static Name nameDeliver = null;
    private static Map mapDeliver = null;

    private static Restaurant restaurant = null;
    private static Address restaruantAddress = null;
    private static Name restaurantName = null;
    private static Rate rateRestaurant = null;


    private static List<Dishes> dishesList = new ArrayList<>();
    private static Dishes dishe = new Dishes();
    private static Description description = null;
    private static Rate rate = null;

    private static Command command = null;




    @BeforeEach
    void setUp() {

        clientName = new Name("clientFirstName", "clientLastName");
        clientAddress = new Address(1, "rue de Paris", 75001, "Paris", "France");
        client = new Client("client@mail.com","000000",clientName, clientAddress, "0000000000","details");

        restaruantAddress = new Address(1,"rue de Marseille",75002,"Paris","France");
        rateRestaurant = new Rate();
        restaurant = new Restaurant("restaurant@mail.com","000000","Chez Itadori","Japonais",restaruantAddress,dishesList,true,rateRestaurant);
        rateRestaurant.addRating(10);
        client = new Client("client@mail.com","000000",clientName, clientAddress, "0000000000","details");

        command = new Command(new ObjectId(),dishesList,client.getId(),)
        when(accountRepository.insert(client)).thenReturn(Optional.of(client));
        when(restaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));

        //Dishe List
        for(int i = 0; i<3; i++){
            description = new Description("plat_"+i,"details",(float)i*10);
            rate = new Rate();
            rate.addRating(i+1);
            dishe = new Dishes(new ObjectId(),description,restaurant.getId(),rate,true);
            dishesList.add(dishe);
        }

    }

    @Test
    void execute() {
    }

    @Test
    void verificationOf() {
    }
}
