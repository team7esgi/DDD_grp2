package model.users;

public class Account {
    private Long id;

    public Account(Long id) {
        this.id = id;
    }

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
