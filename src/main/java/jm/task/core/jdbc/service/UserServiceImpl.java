package jm.task.core.jdbc.service;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.exceptions.SQLError;
import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.hql.internal.antlr.SqlGeneratorBase;
import org.hibernate.hql.internal.ast.SqlGenerator;
import org.hibernate.tool.schema.ast.SqlScriptParserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserServiceImpl extends Util implements UserService {

    Connection connection = getConnection();
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    public void createUsersTable() {
     userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
       userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
          }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
       return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
