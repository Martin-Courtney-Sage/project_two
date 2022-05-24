package services;

import models.Login;

import java.util.List;

public interface LoginService {

    public Login getLogin(int id);

    public Login getLoginByUserID(int userID);

    public List<Login> getAllLogins();

    public Login addLogin(Login l);

    public Login updateLogin(Login change);

    Login updateLoginByUserID(Login change);

    public Login deleteLogin(int id);

    Login deleteLoginByUserID(int id);

}
