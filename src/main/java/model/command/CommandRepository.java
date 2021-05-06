package model.command;

import model.dishes.Dishes;
import model.restaurant.Restaurant;
import model.users.Client;

import java.util.List;
import java.util.Optional;

public interface CommandRepository {

    Optional<Command> createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant);

    Optional<Command> findById(Long id);

    Optional<List<Command>> getAllCommandsForUser(Long userId);

    void rateCommand(Long cliendId, Long commandId, int rate);

}
