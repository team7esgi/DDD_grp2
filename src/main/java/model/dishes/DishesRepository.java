package model.dishes;

import java.util.Optional;

public interface DishesRepository {

    Boolean isAvailable(Long dishId);

    Optional<Dishes> getDish(Long id);

    void rateDish(int rate, Long clientId, Long dishId);

}
