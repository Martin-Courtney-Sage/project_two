package services;

import models.Login;
import repositories.LoginRepo;

import java.util.List;

public class LoginServiceImpl implements LoginService{

    private LoginRepo lr;

    public LoginServiceImpl(LoginRepo lr) {
        this.lr = lr;
    }

    @Override
    public Login getLogin(int id) {
        return lr.getLogin(id);
    }

    @Override
    public Login getLoginByUserID(int userID) {
        return lr.getLoginByUserID(userID);
    }

    @Override
    public List<Login> getAllLogins() {
        return lr.getAllLogins();
    }

    @Override
    public Login addLogin(Login l) {
        return lr.addLogin(l);
    }

    @Override
    public Login updateLogin(Login change) {
        return lr.updateLogin(change);
    }

    @Override
    public Login updateLoginByUserID(Login change) {
        return lr.updateLoginByUserID(change);
    }

    @Override
    public Login deleteLogin(int id) {
        return lr.deleteLogin(id);
    }

    @Override
    public Login deleteLoginByUserID(int id) {
        return lr.deleteLoginByUserID(id);
    }
}
