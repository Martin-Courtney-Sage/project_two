package services;

import models.Account;
import repositories.AccountRepo;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountRepo ar;

    public AccountServiceImpl(AccountRepo ar) {
        this.ar = ar;
    }

    @Override
    public Account getAccount(int id) {
        return ar.getAccount(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return ar.getAllAccounts();
    }

    @Override
    public Account addAccount(Account a) {
        return ar.addAccount(a);
    }

    @Override

    public Account updateAccount(Account change) {
        return ar.updateAccount(change);
    }
    @Override
    public Account deleteAccount(int id) {
        return ar.deleteAccount(id);
    }
}
