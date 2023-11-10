package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {

//        UserService us = new UserServiceImpl();
//
//        us.createUsersTable();
//
//        us.saveUser("Volfgang", "Ivanov", (byte) 114);
//        us.saveUser("Muhammad", "Valkenshtein", (byte) 18);
//        us.saveUser("Vasilij", "Lordkipanidze", (byte) 44);
//        us.saveUser("Sergo", "Bezimjannij", (byte) 23);
//
//        System.out.println(us.getAllUsers());
//
//        us.cleanUsersTable();
//
//        us.dropUsersTable();


        UserDaoHibernateImpl userNew = new UserDaoHibernateImpl();
        userNew.saveUser("Ramesh", "Fadatare", (byte) 4);

    }
}



