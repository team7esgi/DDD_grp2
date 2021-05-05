package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;

import java.util.List;
import java.util.Optional;

public class ShowCommandHistory {

   private final CommandRepository commandRepository;

    public ShowCommandHistory(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public Optional<List<Command>> getCommandHistory(Long clientId){
        return commandRepository.getAllCommandsForUser(clientId);
    }

}
