package use_cases.command;

import model.command.Command;
import model.command.CommandException;
import model.command.CommandRepository;
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

    public void getCommandPosition(Command command) throws CommandException {
        Optional<Command> commandFounded = commandRepository.findById(command.getId());
        if(!commandFounded.isPresent()) throw new CommandException("No such command !");

        Map commandPosition = mapRepository.getCommandPosition(command);
        mapRepository.trackCommandPosition(commandPosition);
    }


}
