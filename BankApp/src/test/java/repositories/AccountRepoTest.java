package repositories;

import models.Account;
import org.junit.jupiter.api.Test;

public class AccountRepoTest {

    AccountRepo ar = new AccountRepoImpl();

    @Test
    public void getAccount() {

        int id = 1;
        Account actual = ar.getAccount(id);
        Account expected = new Account(1, "Gaby123",1,  760);

        assertEquals(expected, actual);

    }

}