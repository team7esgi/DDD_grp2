package model.restaurant;

import model.dishes.Dishes;
import model.users.Account;

import java.util.List;

public class Restaurant extends Account {

    private List<Dishes> dishesList;

    public Restaurant(){

    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dishes> dishesList) {
        this.dishesList = dishesList;
    }
}
