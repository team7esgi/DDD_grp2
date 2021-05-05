package model.maps;

import model.command.Command;

public interface MapRepository {

    public Map getCommandPosition(Command command);

    Map getClientPosition(Long clientId);

    public void trackClientPosition(Map map);

    public void trackCommandPosition(Map map);
}