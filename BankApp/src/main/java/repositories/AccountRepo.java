package repositories;

import models.Account;

import java.util.List;

public interface AccountRepo {

    public Account getAccount(int id);

    public List<Account> getAllAccounts();

    public Account addAccount(Account a);

    public Account updateAccount(Account change);

    public Account deleteAccount(int id);

}
