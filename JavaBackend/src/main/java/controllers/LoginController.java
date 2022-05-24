package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.Login;
import services.LoginService;

import java.util.List;

public class LoginController {

    private LoginService ls;
    private Gson gson = new Gson();

    public LoginController(LoginService ls) {
        this.ls = ls;
    }

    public Handler getAllLogins = (context) -> {

        List<Login> logins = ls.getAllLogins();
        String loginsJSON = gson.toJson(logins);
        //You pass information through result() to send information back (response)
        context.result(loginsJSON);
    };

    public Handler getLoginByID = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Login l = ls.getLogin(id);
        context.result(gson.toJson(l));
    };

    public Handler createLogin = (context) -> {
        Login l = gson.fromJson(context.body(), Login.class);

        l = ls.addLogin(l);
        context.result(gson.toJson(l));
    };

    public Handler updateLogin = (context) -> {
        Login l = gson.fromJson(context.body(), Login.class);

        l = ls.updateLogin(l);
        context.result(gson.toJson(l));
    };

    public Handler deleteLoginById = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Login l = ls.deleteLogin(id);
        context.result(gson.toJson(l));
    };

    public Handler getLoginByUserID = (context) -> {
        int userid = Integer.parseInt(context.pathParam("userid"));
        Login l = ls.getLoginByUserID(userid);
        context.result(gson.toJson(l));
    };

    public Handler updateLoginByUserID = (context) -> {
        Login l = gson.fromJson(context.body(), Login.class);

        l = ls.updateLoginByUserID(l);
        context.result(gson.toJson(l));
    };

    public Handler deleteLoginByUserId = (context) -> {
        int userid = Integer.parseInt(context.pathParam("userid"));
        Login l = ls.deleteLoginByUserID(userid);
        context.result(gson.toJson(l));
    };

    public Handler loginFunction = (context) -> {
        context.result("");
    };

}
