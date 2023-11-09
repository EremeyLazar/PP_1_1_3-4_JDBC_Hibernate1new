package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main (String[] args) {
        // реализуйте алгоритм здесь
        Util util = new Util ();
        util.getConnection();

        UserServiceImpl usi = new UserServiceImpl();
        usi.saveUser("Aleks", "Gerasimov", (byte) 44);




        }
    }



