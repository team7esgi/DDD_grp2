package use_cases.command;

import model.command.Command;
import model.command.CommandException;
import model.command.CommandRepository;
import model.command.CommandState;
import model.maps.MapRepository;
import model.maps.Map;

import java.util.Optional;

public class TrackCommand {

    private final MapRepository mapRepository;
    private final CommandRepository commandRepository;


    public TrackCommand(MapRepository mapRepository, CommandRepository commandRepository) {
        this.mapRepository = mapRepository;
        this.commandRepository = commandRepository;
    }

    public void getCommandPosition(Long commandId) throws CommandException {

        Optional<Command> commandFounded = commandRepository.findById(commandId);
        if(!commandFounded.isPresent()) throw new CommandException("No such command !");
        Command command = commandFounded.get();
        switch (command.getState()) {
            case ACCEPTED :
                System.out.println(CommandState.ACCEPTED.getState());
                command.getPosition().showPosition();
                break;
            case IN_PREPARATION :
                System.out.println(CommandState.IN_PREPARATION.getState());
                command.getPosition().showPosition();
                break;

            case PREPARATION_DONE:
                System.out.println(CommandState.PREPARATION_DONE.getState());
                command.getPosition().showPosition();
                break;

            case IN_TRANSIT :
                command.getPosition().showPosition();
                command.getPosition().showRoute();
                System.out.println(CommandState.IN_TRANSIT.getState());
                break;
            case DELIVERED:
                command.getPosition().showPosition();
                System.out.println(CommandState.DELIVERED.getState());


        }

        Map commandPosition = mapRepository.getCommandPosition(command);
        mapRepository.trackCommandPosition(commandPosition);
    }


}
