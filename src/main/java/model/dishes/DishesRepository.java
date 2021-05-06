package model.dishes;

import model.ObjectId;

import java.util.Optional;

public interface DishesRepository {

    Boolean isAvailable(ObjectId dishId);
    Optional<Dishes> getDish(ObjectId id);
    void rateDish(int rate, ObjectId clientId, ObjectId dishId);

}
