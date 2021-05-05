package model.command;

import model.restaurant.Restaurant;
import model.dishes.Dishes;
import model.users.Client;

import java.util.List;

public interface CommandRepository {
    Command createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant);

    Command findById(Long id);

    List<Command> getAllCommandsForUser(Long userId);

    void rateCommand(Long commandId, int rate);

    void rateDeliverer(Long delivererId, int rate);

    void rateRestaurant(Long restaurantId, int rate);
}
