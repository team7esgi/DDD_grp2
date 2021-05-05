package model.command;

import model.Restaurant;
import model.dishes.Dishes;
import model.users.Client;

import java.util.List;

public interface CommandRepository {
    Command createCommand(List<Dishes> dishesList, Client client, Restaurant restaurant);

    Command findById(Long id);
}
