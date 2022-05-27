package Tests;

import models.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import repositories.UsersRepo;
import repositories.UsersRepoImpl;
import services.UsersService;
import services.UsersServiceImpl;

import java.util.List;

public class UsersTests {

    UsersRepo ur = new UsersRepoImpl();
    UsersService us = new UsersServiceImpl(ur);

    @Test
    public void testGetAllUsers(){

        List<Users> users = us.getAllUsers();
        Assertions.assertTrue(users.size() > 0 && users.size() < 100);
        Assertions.assertEquals(users.get(0),new Users(1,"Jane", "Smith", "JS2022@gmail.com", "555-7882"));
    }

    @Test
    public void testGetUserByID(){

        Users user = us.getUser(1);
        Users expectedUser = new Users(1,"Jane", "Smith", "JS2022@gmail.com", "555-7882");
        Assertions.assertEquals(expectedUser, user, "User does not match");

    }

    @Test
    public void testAddUsers(){

        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");

        Users addedUser = us.addUser(u);

        u.setUserID(addedUser.getUserID());
        Assertions.assertEquals(u, addedUser);

        us.deleteUser(addedUser.getUserID());

    }

    @Test
    public void testUpdateUsers(){

        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        Users userToUpdate = new Users(addedUser.getUserID(), "Jessica", "Doe", "JessDoe@aol.ca", "777-7778");

        Users updatedUser = us.updateUser(userToUpdate);

        Assertions.assertNotEquals(addedUser, updatedUser);
        Assertions.assertEquals(userToUpdate, updatedUser);

        us.deleteUser(updatedUser.getUserID());

    }

    @Test
    public void testDeleteUsers(){

        Users u = new Users(0, "John", "Doe", "JDoe@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        Users deletedUser = us.deleteUser(addedUser.getUserID());
        Assertions.assertEquals(addedUser, deletedUser);

        Users deletedUser2 = us.deleteUser(addedUser.getUserID());
        Assertions.assertNull(deletedUser2);

    }

}
