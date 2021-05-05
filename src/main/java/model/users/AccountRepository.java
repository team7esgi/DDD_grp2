package model.users;

public interface AccountRepository {
    Account findById(Long cliendId);
}
