package use_cases.command;

import model.command.Command;
import model.command.CommandRepository;
import model.maps.MapRepository;
import model.maps.Map;

public class TrackCommand {
    private final MapRepository mapRepository;

    public TrackCommand(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public void getCommandPosition(Command command){
        Map commandPosition = mapRepository.getCommandPosition(command);
        mapRepository.trackCommandPosition(commandPosition);
    }


}
