package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl usi = new UserServiceImpl();

        usi.createUsersTable();

        usi.saveUser("Volfgang", "Ivanov", (byte) 114);
        usi.saveUser("Muhammad", "Valkenshtein", (byte) 18);
        usi.saveUser("Vasilij", "Lordkipanidze", (byte) 44);
        usi.saveUser("Sergo", "Bezimjannij", (byte) 23);

        System.out.println(usi.getAllUsers());

        usi.cleanUsersTable();

        usi.dropUsersTable();

//        SessionFactory factory = new Configuration()
//                .configure("pom.xml")
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory();
//
//        try {
//            Session session = factory.getCurrentSession();
//            User user1 = new User("Aleksander", "Gerasimov", (byte) 44);
//            session.beginTransaction();
//            session.save(user1);
//            session.getTransaction().commit();
//        } finally {
//            factory.close();
//        }
    }
}



