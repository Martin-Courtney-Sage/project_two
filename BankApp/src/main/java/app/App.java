package app;

import controllers.AccountController;
import io.javalin.Javalin;
import repositories.AccountRepo;
import repositories.AccountRepoImpl;
import services.AccountService;
import services.AccountServiceImpl;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

        establishRoutes(app);

        app.start();

    }

    private static void establishRoutes(Javalin app) {

        AccountRepo ar = new AccountRepoImpl();
        AccountService as = new AccountServiceImpl(ar);
        AccountController ac = new AccountController(as);

        app.get("/hello", (context) -> context.result("Hello World!"));
        app.get("/hello2", new HelloHandler());
        app.get("/hello3", ac::anotherHandle);

        app.get("/accounts", ac.getAllAccounts);
        app.get("/accounts/:id", ac.getAccountById);
        app.post("/accounts", ac.createAccount);

        app.routes(() -> {
            path("accounts", () -> {
                get(ac.getAllAccounts);
                post(ac.createAccount);
                path(":id", () -> {
                    get(ac.getAccountById);
                });
            });
        });
    }
}