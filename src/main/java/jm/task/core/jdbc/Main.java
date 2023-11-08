package jm.task.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static Connection main(String[] args) {
        // реализуйте алгоритм здесь

        final String DB_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:~/test";
        final String DB_USERNAME = "ss";
        final String DB_PASSWORD = "";

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
    }

