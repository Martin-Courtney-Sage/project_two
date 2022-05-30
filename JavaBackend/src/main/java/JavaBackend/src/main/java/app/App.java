package app;

import controllers.LoginController;
import controllers.PermissionsController;
import controllers.RegistrationController;
import controllers.UsersController;
import io.javalin.Javalin;
import repositories.*;
import services.*;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

        //Establish our Routes
        establishRoutes(app);

        //Javalin does, by default, run on Port 7000
        app.start();

    }

    private static void establishRoutes(Javalin app) {

        UsersRepo ur = new UsersRepoImpl();
        UsersService us = new UsersServiceImpl(ur);
        UsersController uc = new UsersController(us);

        PermissionsRepo pr = new PermissionsRepoImpl();
        PermissionsService ps = new PermissionsServiceImpl(pr);
        PermissionsController pc = new PermissionsController(ps);

        LoginRepo lr = new LoginRepoImpl();
        LoginService ls = new LoginServiceImpl(lr);
        LoginController lc = new LoginController(ls, ps, us);

        RegistrationController rc = new RegistrationController(ls, ps, us);

        app.get("/hello", (context) -> context.result("Hello World!"));
        app.get("/hello2", new HelloHandler());
        app.get("/hello3", uc::anotherHandle);

        app.routes(() -> {
           path("users", () -> {
               get(uc.getAllUsers);
               post(uc.createUser);
               path(":id", () -> {
                   get(uc.getUserById);
                   put(uc.updateUser);
                   delete(uc.deleteUserById);
               });
           });

            path("logins", () -> {

                get(lc.getAllLogins);

                post(lc.createLogin);

                path(":id", () -> {
                    get(lc.getLoginByID);
                    put(lc.updateLogin);
                    delete(lc.deleteLoginById);
                });

                path("/userId", () -> {
                    path(":userid", () -> {
                        get(lc.getLoginByUserID);
                        put(lc.updateLoginByUserID);
                        delete(lc.deleteLoginByUserId);
                    });

                });

            });

            path("/logmein", () -> {
                post(lc.loginFunction);
            });

            path("/registerme", () -> {
                post(rc.registerUser);
            });


            path("permissions", () -> {

                get(pc.getAllPermissions);

                post(pc.createPermission);

                path(":id", () -> {
                    get(pc.getPermissionByID);
                    put(pc.updatePermissions);
                    delete(pc.deletePermissionById);
                });

                path("/loginId", () -> {
                    path(":loginid", () -> {
                        get(pc.getPermissionByLoginID);
                        delete(pc.deletePermissionByLoginId);
                    });

                });

            });


        });
    }
}