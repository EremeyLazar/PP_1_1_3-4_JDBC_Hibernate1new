package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Util util = new Util();
        util.getConnection();

        UserServiceImpl usi = new UserServiceImpl();

        usi.createUsersTable();

        usi.saveUser("Volfgang", "Ivanov", (byte) 114);
        usi.saveUser("Muhammad", "Valkenshtein", (byte) 18);
        usi.saveUser("Vasilij", "Lordkipanidze", (byte) 44);
        usi.saveUser("Sergo", "Bezimjannij", (byte) 23);

        System.out.println(usi.getAllUsers());

        usi.cleanUsersTable();

        usi.dropUsersTable();


    }
}



