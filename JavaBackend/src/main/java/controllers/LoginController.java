package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.*;
import services.LoginService;
import services.PermissionsService;
import services.UsersService;

import java.util.List;

public class LoginController {

    private LoginService ls;
    private PermissionsService ps;
    private UsersService us;

    private Gson gson = new Gson();

    public LoginController(LoginService ls, PermissionsService ps, UsersService us) {
        this.ls = ls;
        this.ps = ps;
        this.us = us;
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
        LoginFromFrontend lf = gson.fromJson(context.body(), LoginFromFrontend.class);
        Login l = ls.getLoginByUsername(lf.getUsername());
        System.out.println(l);
        if (l!=null) {
            if (lf.getPasscode().equals(l.getPasscode())) {
                SuccessfulLogin sl = new SuccessfulLogin();
                sl.setLoginID(l.getLoginID());
                sl.setUsername(l.getUsername());
                sl.setPasscode(l.getPasscode());

                Users userInfo = us.getUser(l.getUserID());
                if (userInfo != null) {
                    sl.setUserID(userInfo.getUserID());
                    sl.setFirstname(userInfo.getFirstname());
                    sl.setLastname(userInfo.getLastname());
                    sl.setEmail(userInfo.getEmail());
                    sl.setPhone(userInfo.getPhone());
                }

                Permissions permissionsInfo = ps.getPermissionByLoginID(l.getLoginID());
                if (permissionsInfo != null) {
                    sl.setPermID(permissionsInfo.getPermID());
                    sl.setAdminPerm(permissionsInfo.getAdminPerm());
                    sl.setGeneralUser(permissionsInfo.getGeneralUser());
                }
                context.result(gson.toJson(sl));
            } else {
                context.result("message:Invalid Login!");
            }
        }else{
            context.result("message:Invalid Login!");
        }
    };

}
