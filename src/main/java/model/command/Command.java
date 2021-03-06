package model.command;

import model.ObjectId;
import model.dishes.Dishes;
import model.maps.Map;
import model.rate.Rate;

import java.util.List;

public class Command {

    private ObjectId id;

    private List<Dishes> dishesList;

    private ObjectId clientId;

    private ObjectId delivererId;

    private Map position;

    private CommandState state;

    private Rate rate;

    public Command(ObjectId id, List<Dishes> dishesList, ObjectId clientId, ObjectId delivererId, Map position, CommandState state, Rate rate) {
        this.id = id;
        this.dishesList = dishesList;
        this.clientId = clientId;
        this.delivererId = delivererId;
        this.position = position;
        this.state = state;
        this.rate = rate;
    }

    public Command() {
    }

    public void showCommandPosition() throws CommandException {
        switch (this.getState()) {
            case ACCEPTED :
                System.out.println(CommandState.ACCEPTED.getState());
                this.getPosition().showPosition();
                break;
            case IN_PREPARATION :
                System.out.println(CommandState.IN_PREPARATION.getState());
                this.getPosition().showPosition();
                break;

            case PREPARATION_DONE:
                System.out.println(CommandState.PREPARATION_DONE.getState());
                this.getPosition().showPosition();
                break;

            case IN_TRANSIT :
                this.getPosition().showPosition();
                this.getPosition().showRoute();
                System.out.println(CommandState.IN_TRANSIT.getState());
                break;
            case DELIVERED:
                this.getPosition().showPosition();
                System.out.println(CommandState.DELIVERED.getState());

            default : throw new CommandException("State invalid !");

        }
    }

    public ObjectId getId() {
        return this.id;
    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public ObjectId getClientId() {
        return clientId;
    }

    public ObjectId getDelivererId() {
        return delivererId;
    }

    public Map getPosition() {
        return position;
    }

    public CommandState getState() {
        return state;
    }

    public Rate getRate() {
        return rate;
    }
}
