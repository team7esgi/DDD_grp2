package model.maps;

import model.users.Address;

public class Map {

    private Address departure;

    private Address arrival;

    public Map(Address departure, Address arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Map() {
    }

    public void showRoute(){
        System.out.println("Show the route to the ....");
    }

    public void showPosition(){
        System.out.println("Show the route to the ....");
    }


}
