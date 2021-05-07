package use_cases.command;

import model.ObjectId;
import model.command.Command;
import model.command.CommandException;
import model.command.CommandRepository;
import model.maps.MapRepository;

import java.util.Optional;

import static model.command.Command.verificationOfCommand;

public class TrackCommand {

    private final MapRepository mapRepository;
    private final CommandRepository commandRepository;


    public TrackCommand(MapRepository mapRepository, CommandRepository commandRepository) {
        this.mapRepository = mapRepository;
        this.commandRepository = commandRepository;
    }

    public void execute(ObjectId commandId) throws CommandException {

        Optional<Command> commandFounded = commandRepository.findById(commandId);

        verificationOfCommand(commandFounded);

        commandFounded.get().showCommandPosition();
    }



}
