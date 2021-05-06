package model.command;

import model.dishes.Dishes;
import model.maps.Map;

import java.util.List;

public class Command {


    private Long id;

    private List<Dishes> dishesList;

    private Long clientId;

    private Long delivererId;

    private Map position;

    private CommandState state;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dishes> dishesList) {
        this.dishesList = dishesList;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDelivererId() {
        return delivererId;
    }

    public void setDelivererId(Long delivererId) {
        this.delivererId = delivererId;
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

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", dishesList=" + dishesList +
                ", clientId=" + clientId +
                ", delivererId=" + delivererId +
                ", position=" + position +
                ", state=" + state +
                '}';
    }
}
