package model.maps;

import model.ObjectId;
import model.command.Command;

public interface MapRepository {

    public Map getCommandPosition(Command command);

    Map getClientPosition(ObjectId clientId);

    public void trackClientPosition(Map map);

    public void trackCommandPosition(Map map);
}
