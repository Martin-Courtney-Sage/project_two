package services;

import models.Users;
import repositories.UsersRepo;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersRepo ur;

    public UsersServiceImpl(UsersRepo ur) {
        this.ur = ur;
    }

    @Override
    public Users getUser(int id) {
        return ur.getUser(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return ur.getAllUsers();
    }

    @Override
    public Users addUser(Users u) {
        return ur.addUser(u);
    }

    @Override
    public Users updateUser(Users change) {
        return ur.updateUser(change);
    }

    @Override
    public Users deleteUser(int id) {
        return ur.deleteUser(id);
    }
}
