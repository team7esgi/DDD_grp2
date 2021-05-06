package model.restaurant;

import model.dishes.Dishes;
import model.users.Account;

import java.util.List;

public class Restaurant extends Account {

    private List<Dishes> dishesList;
    private Long id;
    private boolean available;

    public Restaurant(){

    }

    public boolean isAvailable() {return this.available; }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dishes> dishesList) {
        this.dishesList = dishesList;
    }

    public Long getId() {
        return this.id;
    }
}
