package Tests;

import models.Login;
import models.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.LoginRepo;
import repositories.LoginRepoImpl;
import repositories.UsersRepo;
import repositories.UsersRepoImpl;
import services.LoginService;
import services.LoginServiceImpl;
import services.UsersService;
import services.UsersServiceImpl;

import java.util.List;

public class LoginTests {
    LoginRepo lr = new LoginRepoImpl();
    LoginService ls = new LoginServiceImpl(lr);

    UsersRepo ur = new UsersRepoImpl();
    UsersService us = new UsersServiceImpl(ur);

    @Test
    public void testGetLogin(){
        Login login = ls.getLogin(1);
        Login expectedLogin = new Login(1,1,"test101","pass1234");
        Assertions.assertEquals(expectedLogin, login);
    }

    @Test
    public void testGetLoginByUserID(){
        Login login = ls.getLoginByUserID(1);
        Login expectedLogin = new Login(1,1,"test101","pass1234");
        Assertions.assertEquals(expectedLogin, login);
    }

    @Test
    public void testGetLoginByUsername(){
        Login login = ls.getLoginByUsername("test101");
        Login expectedLogin = new Login(1,1,"test101","pass1234");
        Assertions.assertEquals(expectedLogin, login);
    }

    @Test
    public void testGetAllLogins() {
        List<Login> logins = ls.getAllLogins();
        Assertions.assertTrue(logins.size() > 0 && logins.size() < 100);
        Assertions.assertEquals(logins.get(0), new Login(1,1,"test101","pass1234"));
    }

    @Test
    public void testAddLogin() {
        // Create a random user for which we will create a login.
        Users u = new Users(0, "TestFirstname", "TestLastname", "Test@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");

        Login addedLogin = ls.addLogin(l);

        l.setLoginID(addedLogin.getLoginID());
        Assertions.assertEquals(l, addedLogin);

        ls.deleteLogin(addedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());

    }

    @Test
    public void testUpdateLogin() {

        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");

        Login addedLogin = ls.addLogin(l);

        Login loginToUpdate = new Login(addedLogin.getLoginID(), addedUser.getUserID(), "TestUpdatedUsername", "TestUpdatedPasscode");

        Login updatedLogin = ls.updateLogin(loginToUpdate);

        Assertions.assertNotEquals(addedLogin, updatedLogin);
        Assertions.assertEquals(loginToUpdate, updatedLogin);

        ls.deleteLogin(updatedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());

    }

    @Test
    public void testUpdateLoginByUserID(){
        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");

        Login addedLogin = ls.addLogin(l);

        Login loginToUpdate = new Login(addedLogin.getLoginID(), addedUser.getUserID(), "TestUpdatedUsername", "TestUpdatedPasscode");

        Login updatedLogin = ls.updateLoginByUserID(loginToUpdate);

        Assertions.assertNotEquals(addedLogin, updatedLogin);
        Assertions.assertEquals(loginToUpdate, updatedLogin);

        ls.deleteLogin(updatedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());
    }

    @Test
    public void testDeleteLogin() {

        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");

        Login addedLogin = ls.addLogin(l);

        Login deletedLogin = ls.deleteLogin(addedLogin.getLoginID());
        Assertions.assertEquals(addedLogin, deletedLogin);

        Login deletedLogin2 = ls.deleteLogin(addedLogin.getLoginID());
        Assertions.assertNull(deletedLogin2);

        us.deleteUser(addedUser.getUserID());

    }

    @Test
    public void testDeleteLoginByUserID() {

        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");

        Login addedLogin = ls.addLogin(l);

        Login deletedLogin = ls.deleteLoginByUserID(addedLogin.getUserID());
        Assertions.assertEquals(addedLogin, deletedLogin);

        Login deletedLogin2 = ls.deleteLoginByUserID(addedLogin.getUserID());
        Assertions.assertNull(deletedLogin2);

        us.deleteUser(addedUser.getUserID());

    }

}
