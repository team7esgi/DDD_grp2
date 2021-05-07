package use_cases.command;

import model.ObjectId;
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

    public void execute(ObjectId commandId) throws CommandException {

        Optional<Command> commandFounded = commandRepository.findById(commandId);

        if(!commandFounded.isPresent()) throw new CommandException("No such command !");

        commandFounded.get().showCommandPosition();
    }




}
