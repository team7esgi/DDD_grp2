package model.command;

import model.dishes.Dishes;

import java.util.List;

public class Command {

    private Long id;

    private List<Dishes> dishesList;

    private Long clientId;

    private Long delivererId;

    public Long getId() {
        return this.id;
    }
}
