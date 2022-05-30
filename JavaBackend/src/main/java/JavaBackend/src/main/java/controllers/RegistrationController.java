package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.*;
import services.LoginService;
import services.PermissionsService;
import services.UsersService;

import java.util.List;

public class RegistrationController {

    private LoginService ls;
    private PermissionsService ps;
    private UsersService us;

    private Gson gson = new Gson();

    public RegistrationController(LoginService ls, PermissionsService ps, UsersService us) {
        this.ls = ls;
        this.ps = ps;
        this.us = us;
    }

    public Handler registerUser = (context) -> {

        RegistrationDetails rd = gson.fromJson(context.body(), RegistrationDetails.class);

        Login l = ls.getLoginByUsername(rd.getUsername());

        if (l==null){
            Users nu = new Users(0,rd.getFirstname(),rd.getLastname(),rd.getEmail(),rd.getPhone());
            Users addedUser = us.addUser(nu);
            Login nl = new Login(0,addedUser.getUserID(),rd.getUsername(),rd.getPasscode());
            Login addedlogin = ls.addLogin(nl);
            Permissions np = new Permissions(1,addedlogin.getLoginID(), null, "generalUser");

            SuccessfulLogin sl = new SuccessfulLogin();
            sl.setLoginID(nl.getLoginID());
            sl.setUsername(nl.getUsername());
            sl.setPasscode(nl.getPasscode());
            sl.setUserID(addedUser.getUserID());
            sl.setFirstname(addedUser.getFirstname());
            sl.setLastname(addedUser.getLastname());
            sl.setEmail(addedUser.getEmail());
            sl.setPhone(addedUser.getPhone());
            sl.setPermID(np.getPermID());
            sl.setAdminPerm(np.getAdminPerm());
            sl.setGeneralUser(np.getGeneralUser());

            context.result(gson.toJson(sl));

        }else{
            context.result("{\"message\":\"username already exists\"}");
        }
    };
}
