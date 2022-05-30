package repositories;

import models.Login;
import models.Users;

import java.util.List;

public interface LoginRepo {

    public Login getLogin(int id);

    public Login getLoginByUserID(int userID);

    public Login getLoginByUsername(String username);

    public List<Login> getAllLogins();

    public Login addLogin(Login l);

    public Login updateLogin(Login change);

    public Login updateLoginByUserID(Login change);

    public Login deleteLogin(int id);

    public Login deleteLoginByUserID(int id);
}
