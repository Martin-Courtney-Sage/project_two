package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {

            try {
                // May break when packaging up your project, in the future.
//              FileInputStream input = new FileInputStream("src/main/resources/connection.properties");

                // Two different ways to get our Resource File, in an OOP fashion, that doesn't rely on a File Path.
                // First Way
                FileInputStream input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
                // Second Way
                // InputStream input2 = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");

                Properties props = new Properties();
                props.load(input);

                String endpoint = props.getProperty("endpoint");
                String database = props.getProperty("database");
                String url = "jdbc:postgresql://" + endpoint + "/" + database;
                String username = props.getProperty("username");
                String password = props.getProperty("password");


                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return conn;
    }

    //This is for testing purposes only. Not needed to actually use JDBC.
    public static void main(String[] args) {

        Connection conn1 = getConnection();
        Connection conn2 = getConnection();

        System.out.println(conn1);
        System.out.println(conn2);

    }

}