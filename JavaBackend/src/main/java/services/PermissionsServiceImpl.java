package services;

import models.Permissions;
import repositories.PermissionsRepo;

import java.util.List;

public class PermissionsServiceImpl implements PermissionsService{

    private PermissionsRepo pr;

    public PermissionsServiceImpl(PermissionsRepo pr) {
        this.pr = pr;
    }

    @Override
    public Permissions getPermission(int id) {
        return pr.getPermission(id);
    }

    @Override
    public Permissions getPermissionByLoginID(int loginID) {
        return pr.getPermissionByLoginID(loginID);
    }

    @Override
    public List<Permissions> getAllPermissions() {
        return pr.getAllPermissions();
    }

    @Override
    public Permissions addPermission(Permissions p) {
        return pr.addPermission(p);
    }

    @Override
    public Permissions updatePermission(Permissions change) {
        return pr.updatePermission(change);
    }

    @Override
    public Permissions deletePermission(int id) {
        return pr.deletePermission(id);
    }

    @Override
    public Permissions deletePermissionByLoginID(int id) {
        return pr.deletePermissionByLoginID(id);
    }
}
