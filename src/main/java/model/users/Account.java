package model.users;

import model.ObjectId;

public class Account {

    private ObjectId id;
    private String email;
    private String password;

    public Account(String email, String password) {
        this.id = new ObjectId();
        this.email = email;
        this.password = password;
    }

    public Account() {
    }

    public ObjectId getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
