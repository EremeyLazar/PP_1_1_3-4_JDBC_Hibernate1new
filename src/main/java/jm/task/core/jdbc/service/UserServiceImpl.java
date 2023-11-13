package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDao hibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
//        userDao.createUsersTable();
        hibernate.createUsersTable();
    }

    public void dropUsersTable() {
//        userDao.dropUsersTable();
        hibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        userDao.saveUser(name, lastName, age);
        hibernate.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных.");
    }

    public void removeUserById(long id) {
//        userDao.removeUserById(id);
        hibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
        return hibernate.getAllUsers();
    }

    public void cleanUsersTable() {
//        userDao.cleanUsersTable();
        hibernate.cleanUsersTable();
    }
}
