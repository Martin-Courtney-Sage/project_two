package repositories;

import models.Login;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepoImpl implements LoginRepo{

    public static Connection conn = JDBCConnection.getConnection();

    public LoginRepoImpl(){
    }

    // Structure: int loginID, int userID, String username, String passcode

    @Override
    public Login getLogin(int id) {
        String sql = "SELECT * FROM login WHERE loginID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login getLoginByUserID(int userID) {
        String sql = "SELECT * FROM login WHERE userID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login getLoginByUsername(String username) {
        String sql = "SELECT * FROM login WHERE username = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Login> getAllLogins() {
        String sql = "SELECT * FROM login";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Login> logins = new ArrayList<>();

            while(rs.next()) {
                logins.add(buildLogin(rs));
            }

            return logins;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login addLogin(Login l) {
        String sql = "INSERT INTO login VALUES (DEFAULT,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, l.getUserID());
            ps.setString(2, l.getUsername());
            ps.setString(3, l.getPasscode());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildLogin(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login updateLogin(Login change) {
        try {
            String sql = "UPDATE login SET username=?, passcode=? WHERE loginID = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getUsername());
            ps.setString(2, change.getPasscode());
            ps.setInt(3, change.getLoginID());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login updateLoginByUserID(Login change) {
        try {
            String sql = "UPDATE login SET username=?, passcode=? WHERE userID = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getUsername());
            ps.setString(2, change.getPasscode());
            ps.setInt(3, change.getUserID());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login deleteLogin(int id) {
        try {
            String sql = "DELETE FROM login WHERE loginID = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Login deleteLoginByUserID(int id) {
        try {
            String sql = "DELETE FROM login WHERE userID = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildLogin(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Login buildLogin(ResultSet rs) throws SQLException {
        Login l = new Login();
        l.setLoginID(rs.getInt("loginid"));
        l.setUserID(rs.getInt("userid"));
        l.setUsername(rs.getString("username"));
        l.setPasscode(rs.getString("passcode"));

        return l;
    }

}
