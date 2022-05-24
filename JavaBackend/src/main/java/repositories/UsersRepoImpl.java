package repositories;

import models.Users;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepoImpl implements UsersRepo {

    public static Connection conn = JDBCConnection.getConnection();

    public UsersRepoImpl(){ }

    @Override
    public Users getUser(int id) {
        String sql = "SELECT * FROM users WHERE userid = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Users> users = new ArrayList<>();

            while(rs.next()) {
                users.add(buildUser(rs));
            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Users addUser(Users u) {
        String sql = "INSERT INTO users VALUES (DEFAULT,?,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getFirstname());
            ps.setString(2, u.getLastname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhone());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Users updateUser(Users change) {
        try {
            String sql = "UPDATE users SET firstname=?, lastname=?, email=?, phone=? WHERE userid = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getFirstname());
            ps.setString(2, change.getLastname());
            ps.setString(3, change.getEmail());
            ps.setString(4, change.getPhone());
            ps.setInt(5, change.getUserID());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Users deleteUser(int id) {
        try {
            String sql = "DELETE FROM users WHERE userid = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Users buildUser(ResultSet rs) throws SQLException {
        Users u = new Users();
        u.setUserID(rs.getInt("userid"));
        u.setFirstname(rs.getString("firstname"));
        u.setLastname(rs.getString("lastname"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));

        return u;
    }

}
