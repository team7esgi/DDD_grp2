package model.restaurant;

import model.dishes.Dishes;
import model.users.Account;

import java.util.List;

public class Restaurant extends Account {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    private boolean available;

    private String name;

    private String category;

    private String address;

    private List<Dishes> dishesList;

    private boolean isOpen;


    public Restaurant(){

    }

    public Restaurant(Long id, boolean available, String name, String category, String address, List<Dishes> dishesList, boolean isOpen) {
        this.id = id;
        this.available = available;
        this.name = name;
        this.category = category;
        this.address = address;
        this.dishesList = dishesList;
        this.isOpen = isOpen;
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
