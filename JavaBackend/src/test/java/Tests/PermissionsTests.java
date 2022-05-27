package Tests;

import models.Login;
import models.Permissions;
import models.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.*;
import services.*;

import java.util.List;

public class PermissionsTests {

    LoginRepo lr = new LoginRepoImpl();
    LoginService ls = new LoginServiceImpl(lr);

    UsersRepo ur = new UsersRepoImpl();
    UsersService us = new UsersServiceImpl(ur);

    PermissionsRepo pr = new PermissionsRepoImpl();
    PermissionsService ps = new PermissionsServiceImpl(pr);

    @Test
    public void testGetPermission(){
        Permissions permission = ps.getPermission(1);
        Assertions.assertEquals(permission, new Permissions(1,1,"adminPerm",null));
    }

    @Test
    public void testGetPermissionByLoginID(){
        Permissions permission = ps.getPermissionByLoginID(1);
        Assertions.assertEquals(permission, new Permissions(1,1,"adminPerm",null));
    }

    @Test
    public void testGetAllPermissions(){
        List<Permissions> permissions = ps.getAllPermissions();
        Assertions.assertTrue(permissions.size() > 0 && permissions.size() < 100);
        Assertions.assertEquals(permissions.get(0), new Permissions(1,1,"adminPerm",null));
    }

    @Test
    public void testAddPermission(){
        // Create a random user for which we will create a login.
        Users u = new Users(0, "TestFirstname", "TestLastname", "Test@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");
        Login addedLogin = ls.addLogin(l);

        //Create permission
        Permissions p = new Permissions(0,addedLogin.getLoginID(),"adminPerm",null);
        Permissions addedPermissions = ps.addPermission(p);

        p.setPermID(addedPermissions.getPermID());
        Assertions.assertEquals(p, addedPermissions);

        ps.deletePermission(addedPermissions.getPermID());
        ls.deleteLogin(addedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());

    }

    @Test
    public void testUpdatePermission(){
        // Create a random user for which we will create a login.
        Users u = new Users(0, "TestFirstname", "TestLastname", "Test@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");
        Login addedLogin = ls.addLogin(l);

        //Create permission
        Permissions p = new Permissions(0,addedLogin.getLoginID(),"adminPerm",null);
        Permissions addedPermissions = ps.addPermission(p);

        Permissions permissionToUpdate = new Permissions(addedPermissions.getPermID(), addedLogin.getLoginID(), null, "generalUser");
        Permissions updatedPermission = ps.updatePermission(permissionToUpdate);

        Assertions.assertNotEquals(addedPermissions, updatedPermission);
        Assertions.assertEquals(permissionToUpdate, updatedPermission);

        ps.deletePermission(updatedPermission.getPermID());
        ls.deleteLogin(addedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());

    }

    @Test
    public void testDeletePermission(){
        // Create a random user for which we will create a login.
        Users u = new Users(0, "TestFirstname", "TestLastname", "Test@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");
        Login addedLogin = ls.addLogin(l);

        //Create permission
        Permissions p = new Permissions(0,addedLogin.getLoginID(),"adminPerm",null);
        Permissions addedPermissions = ps.addPermission(p);

        Permissions deletedPermissions = ps.deletePermission(addedPermissions.getPermID());
        Assertions.assertEquals(addedPermissions, deletedPermissions);

        Permissions deletedPermissions2 = ps.deletePermission(addedPermissions.getPermID());
        Assertions.assertNull(deletedPermissions2);

        ls.deleteLogin(addedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());
    }

    @Test
    public void testDeletePermissionByLoginID(){
        // Create a random user for which we will create a login.
        Users u = new Users(0, "TestFirstname", "TestLastname", "Test@aol.com", "777-7777");
        Users addedUser = us.addUser(u);

        //Create login
        Login l = new Login(0, addedUser.getUserID(),"TestUsername","TestPasscode");
        Login addedLogin = ls.addLogin(l);

        //Create permission
        Permissions p = new Permissions(0,addedLogin.getLoginID(),"adminPerm",null);
        Permissions addedPermissions = ps.addPermission(p);

        Permissions deletedPermissions = ps.deletePermissionByLoginID(addedPermissions.getLoginID());
        Assertions.assertEquals(addedPermissions, deletedPermissions);

        Permissions deletedPermissions2 = ps.deletePermissionByLoginID(addedPermissions.getLoginID());
        Assertions.assertNull(deletedPermissions2);

        ls.deleteLogin(addedLogin.getLoginID());
        us.deleteUser(addedUser.getUserID());
    }

}
