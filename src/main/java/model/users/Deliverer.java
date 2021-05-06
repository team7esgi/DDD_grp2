package model.users;

import model.maps.Map;
import model.rate.Rate;

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

    public Map getPosition() {
        return position;
    }

    public void setPosition(Map position) {
        this.position = position;
    }

    public Map getRoute() {
        return route;
    }

    public void setRoute(Map route) {
        this.route = route;
    }
}
