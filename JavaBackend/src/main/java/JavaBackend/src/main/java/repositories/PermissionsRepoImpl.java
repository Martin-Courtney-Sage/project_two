package repositories;

import models.Permissions;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionsRepoImpl implements PermissionsRepo {

    public static Connection conn = JDBCConnection.getConnection();

    public PermissionsRepoImpl(){

    }

    // Structure: int permID, int loginID, String adminPerm, String generalUser

    @Override
    public Permissions getPermission(int id) {
        String sql = "SELECT * FROM permissions WHERE permid = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPermission(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Permissions getPermissionByLoginID(int loginID) {
        String sql = "SELECT * FROM permissions WHERE loginid = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPermission(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Permissions> getAllPermissions() {
        String sql = "SELECT * FROM permissions";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Permissions> permissions = new ArrayList<>();

            while(rs.next()) {
                permissions.add(buildPermission(rs));
            }

            return permissions;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Permissions addPermission(Permissions p) {
        String sql = "INSERT INTO permissions VALUES (DEFAULT,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, p.getLoginID());
            ps.setString(2, p.getAdminPerm());
            ps.setString(3, p.getGeneralUser());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildPermission(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Permissions updatePermission(Permissions change) {
        try {
            String sql = "UPDATE permissions SET adminperm=?, generaluser=? WHERE permid = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getAdminPerm());
            ps.setString(2, change.getGeneralUser());
            ps.setInt(3, change.getPermID());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPermission(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Permissions deletePermission(int id) {
        try {
            String sql = "DELETE FROM permissions WHERE permid = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPermission(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Permissions deletePermissionByLoginID(int id) {
        try {
            String sql = "DELETE FROM permissions WHERE loginid = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildPermission(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Permissions buildPermission(ResultSet rs) throws SQLException {
        Permissions p = new Permissions();
        p.setPermID(rs.getInt("permID"));
        p.setLoginID(rs.getInt("loginID"));
        p.setAdminPerm(rs.getString("adminperm"));
        p.setGeneralUser(rs.getString("generaluser"));

        return p;
    }

}
