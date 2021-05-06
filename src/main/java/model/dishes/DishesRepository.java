package model.dishes;

import model.ObjectId;

import java.util.Optional;

public interface DishesRepository {

    Boolean isAvailable(Long dishId);

    Optional<Dishes> getDish(Long id);

    void rateDish(int rate, ObjectId clientId, ObjectId dishId);

}
