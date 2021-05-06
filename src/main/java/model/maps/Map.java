package model.maps;

import model.command.Command;
import model.users.Deliver;

public class Map {

    private String departure;

    private String arrival;

    public Map(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public void showRoute(){
        System.out.println("Show the route to the ....");
    }

    public void showPosition(){
        System.out.println("Show the route to the ....");
    }


}
