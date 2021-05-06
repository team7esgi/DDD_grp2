package model.maps;

import model.ObjectId;
import model.command.Command;

public interface MapRepository {

    Map getCommandPosition(Command command);

    Map getClientPosition(ObjectId clientId);

    void trackClientPosition(Map map);

    void trackCommandPosition(Map map);
}
