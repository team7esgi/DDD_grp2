package model.users;

import model.maps.Map;
import model.rate.Rate;

import java.util.Optional;

public class Deliverer extends Account {

    private final Name name;

    private Map position;

    private Map route;

    private Rate rate;

    public Deliverer(String email, String password, Name name, Map position, Map route, Rate rate) {
        super(email, password);
        this.name = name;
        this.position = position;
        this.route = route;
        this.rate = rate;
    }

    public static void verificationOfDeliverer(Optional<Account> isDelivererPresent) throws AccountException {
        if(!isDelivererPresent.isPresent()) throw new AccountException("No such deliverer !");
    }


    public Deliverer() {
        this.name = null;
    }

    public Map getPosition() {
        return position;
    }

    public Map getRoute() {
        return route;
    }

}
