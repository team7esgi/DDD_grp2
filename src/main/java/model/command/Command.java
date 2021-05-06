package model.command;

import model.ObjectId;
import model.dishes.Dishes;
import model.maps.Map;

import java.util.List;

public class Command {

    private ObjectId id;

    private List<Dishes> dishesList;

    private ObjectId clientId;

    private ObjectId delivererId;

    private Map position;

    private CommandState state;

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

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dishes> dishesList) {
        this.dishesList = dishesList;
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

    public void setPosition(Map position) {
        this.position = position;
    }

    public CommandState getState() {
        return state;
    }

    public void setState(CommandState state) {
        this.state = state;
    }
}
