package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.Login;
import models.Permissions;
import services.PermissionsService;

import java.util.List;

public class PermissionsController {

    private PermissionsService ps;
    private Gson gson = new Gson();

    public PermissionsController(PermissionsService ps) {
        this.ps = ps;
    }

    public Handler getAllPermissions = (context) -> {

        List<Permissions> permissions = ps.getAllPermissions();
        String permissionsJSON = gson.toJson(permissions);
        //You pass information through result() to send information back (response)
        context.result(permissionsJSON);
    };

    public Handler getPermissionByID = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Permissions p = ps.getPermission(id);
        context.result(gson.toJson(p));
    };

    public Handler createPermission = (context) -> {
        Permissions p = gson.fromJson(context.body(), Permissions.class);

        p = ps.addPermission(p);
        context.result(gson.toJson(p));
    };

    public Handler updatePermissions = (context) -> {
        Permissions p = gson.fromJson(context.body(), Permissions.class);

        p = ps.updatePermission(p);
        context.result(gson.toJson(p));
    };

    public Handler deletePermissionById = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Permissions p = ps.deletePermission(id);
        context.result(gson.toJson(p));
    };

    public Handler getPermissionByLoginID = (context) -> {
        int loginid = Integer.parseInt(context.pathParam("loginid"));
        Permissions p = ps.getPermissionByLoginID(loginid);
        context.result(gson.toJson(p));
    };

    public Handler deletePermissionByLoginId = (context) -> {
        int loginid = Integer.parseInt(context.pathParam("loginid"));
        Permissions p = ps.deletePermissionByLoginID(loginid);
        context.result(gson.toJson(p));
    };

}
