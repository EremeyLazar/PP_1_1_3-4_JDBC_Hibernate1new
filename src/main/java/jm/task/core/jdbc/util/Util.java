package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    final String DB_URL = "jdbc:mysql://localhost:3306/users";
    final String DB_USERNAME = "root";
    final String DB_PASSWORD = "Ьнакуувщь1001011";


    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return connection;
    }

    public SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        Properties settings = new Properties();

        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, DB_URL);
        settings.put(Environment.USER, DB_USERNAME);
        settings.put(Environment.PASS, DB_PASSWORD);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "");

        configuration.setProperties(settings);

        sessionFactory = configuration.addAnnotatedClass(User.class).buildSessionFactory();

        return sessionFactory;
    }
}

