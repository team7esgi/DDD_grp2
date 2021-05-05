package model.maps;

import model.command.Command;

public interface IMaps {

    public Map getCommandPosition(Command command);


    public void trackCommandPosition(Map map);
}
