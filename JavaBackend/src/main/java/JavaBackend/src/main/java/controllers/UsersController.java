package controllers;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import models.Users;
import services.UsersService;

import java.util.List;

public class UsersController {

    private UsersService us;
    private Gson gson = new Gson();

    public UsersController(UsersService us) {
        this.us = us;
    }

    public Handler getAllUsers = (context) -> {

        List<Users> users = us.getAllUsers();
        String usersJSON = gson.toJson(users);
        //You pass information through result() to send information back (response)
        context.result(usersJSON);
    };

    public Handler getUserById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Users u = us.getUser(id);
        context.result(gson.toJson(u));
    };

    public Handler createUser = (context) -> {
        Users u = gson.fromJson(context.body(), Users.class);

        u = us.addUser(u);
        context.result(gson.toJson(u));
    };

    public Handler updateUser = (context) -> {
        Users u = gson.fromJson(context.body(), Users.class);

        u = us.updateUser(u);
        context.result(gson.toJson(u));
    };

    public Handler deleteUserById = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Users u = us.deleteUser(id);
        context.result(gson.toJson(u));
    };

    public void anotherHandle(Context ctx) {
        ctx.result("Another example");
    }

}
