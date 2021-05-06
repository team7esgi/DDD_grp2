package model.command;

import model.ObjectId;
import model.dishes.Dishes;

import java.util.List;
import java.util.Optional;

public interface CommandRepository {

    Optional<Command> createCommand(List<Dishes> dishesList, ObjectId client, ObjectId restaurant);

    Optional<Command> findById(ObjectId id);

    Optional<List<Command>> getAllCommandsForUser(ObjectId userId);

    void rateCommand(ObjectId clientId, ObjectId commandId, int rate);

}
