package repositories;

import models.Permissions;

import java.util.List;

public interface PermissionsRepo {

    public Permissions getPermission(int id);

    public Permissions getPermissionByLoginID(int loginID);

    public List<Permissions> getAllPermissions();

    public Permissions addPermission(Permissions p);

    public Permissions updatePermission(Permissions change);

    public Permissions deletePermission(int id);

    public Permissions deletePermissionByLoginID(int id);
}
