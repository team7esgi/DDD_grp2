package model;

import java.util.UUID;

public class ObjectId {
    private final UUID id;

    public ObjectId(){
        this.id = UUID.randomUUID();
    }

}
