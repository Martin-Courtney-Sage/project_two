package controllers;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import models.Account;
import services.AccountService;

import java.util.List;

public class AccountController {

    private AccountService as;
    private Gson gson = new Gson();

    public AccountController(AccountService as) {
        this.as = as;
    }

    public Handler getAllAccounts = (context) -> {

        List<Account> accounts = as.getAllAccounts();
        String accountsJSON = gson.toJson(accounts);
        context.result(accountsJSON);
    };

    public Handler getAccountById = (context) -> {

        int id = Integer.parseInt(context.pathParam("userId"));
        Account a = as.getAccount(id);
        context.result(gson.toJson(a));
    };

    public Handler createAccount = (context) -> {
        Account a = gson.fromJson(context.body(), Account.class);

        a = as.addAccount(a);
        context.result(gson.toJson(a));
    };

    public void anotherHandle(Context ctx) {
        ctx.result("Another Account");
    }

}