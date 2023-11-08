package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    final String DB_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/users";
    final String DB_USERNAME = "root";
    final String DB_PASSWORD = "Ьнакуувщь1001011";

    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection DONE");
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return connection;
    }
}
