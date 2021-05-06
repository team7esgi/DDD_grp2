package model.users;

import model.maps.Map;

public class Deliver extends Account {

    private Map position;

    private Map route;

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
