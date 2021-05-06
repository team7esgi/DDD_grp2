package model.command;

public enum CommandState {
    ACCEPTED("accepted"),
    IN_PREPARATION("In preparation"),
    PREPARATION_DONE("preparation done"),
    IN_TRANSIT("in transit"),
    DELIVERED("delivered");

    private String State;

    CommandState(String state) {
        State = state;
    }

    public String getState(){return this.State;}
}
