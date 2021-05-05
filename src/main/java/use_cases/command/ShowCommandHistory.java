package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;

import java.util.List;

public class ShowCommandHistory {
    CommandRepository commandRepository;

    public List<Command> getCommandHistory(Long clientId){
        return commandRepository.getAllCommandsForUser(clientId);
    }

}
