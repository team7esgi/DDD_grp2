package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;
import model.maps.IMaps;
import model.maps.Map;

public class TrackCommand {
    CommandRepository commandRepository;
    IMaps mapsService;

    public void getCommandPosition(Command command){
        Map commandPosition = mapsService.getCommandPosition(command);
        mapsService.trackCommandPosition(commandPosition);
    }


}
