package use_cases.rate;

import model.ObjectId;
import model.dishes.Description;
import model.dishes.Dishes;
import model.rate.Rate;
import model.restaurant.Restaurant;
import model.restaurant.RestaurantException;
import model.restaurant.RestaurantRepository;
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

class RateRestaurantTest {


    AccountRepository mockAccountRepository = mock(AccountRepository.class);
    RestaurantRepository mockRestaurantRepository = mock(RestaurantRepository.class);

    RateRestaurant rateRestaurant;

    Client client = null;
    Dishes dish = null;
    List<Dishes> dishesList = new ArrayList<Dishes>();
    Restaurant restaurant = null;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Name name = new Name("test1", "test2");
        Address address = new Address(12, "street", 75010, "Paris", "France");
        client = new Client("test@mail.com", "password",name,
                address,"0000000000", "des details");

        for(int i = 0; i<3; i++){
            ObjectId objectId = new ObjectId();
            ObjectId restaurantId = new ObjectId();
            Description description = new Description("descriptDish", "plat_"+i, 14);
            Rate rateDish = new Rate();
            dish = new Dishes(objectId, description, restaurantId, rateDish, true);//(objectId,description, restaurantId, rateDish, true);
            dishesList.add(dish);
        }

        restaurant = new Restaurant("test1@test.com", "password", "restau1",
                "chinois", address, dishesList, true, new Rate());

        Rate rateCommand = new Rate();
        rateCommand.addRating(5);
        when(mockAccountRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(mockRestaurantRepository.findById(restaurant.getId())).thenReturn(Optional.of(restaurant));

        rateRestaurant =  new RateRestaurant(mockRestaurantRepository, mockAccountRepository);

    }

    @Test
    void rateRestaurant() {
        assertDoesNotThrow(() -> rateRestaurant.execute(client.getId(), restaurant.getId(), 5));
    }

    @Test
    void rateRestaurantExceptionRate() {
        assertThrows(Exception.class, () -> rateRestaurant.execute(client.getId(), restaurant.getId(), 10));
    }

    @Test
    void rateRestaurantExceptionClient() {
        assertThrows(AccountException.class, () -> rateRestaurant.execute(new ObjectId(), restaurant.getId(), 5));
    }

    @Test
    void rateRestaurantExceptionRestaurant() {
        assertThrows(RestaurantException.class, () -> rateRestaurant.execute(client.getId(), new ObjectId(), 5));
    }
}
