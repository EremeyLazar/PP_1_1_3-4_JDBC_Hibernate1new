package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = new Util().getSessionFactory();

    private <T> T todo(final Function<Session, T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            T act = command.apply(session);
            transaction.commit();
            return act;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        todo(session -> session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45) NOT NULL, lastName VARCHAR(45) NOT NULL, age TINYINT)").executeUpdate());
    }

    @Override
    public void dropUsersTable() {
        todo(session -> session.createSQLQuery("DROP TABLE IF EXISTS Users").executeUpdate());
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        todo(session -> session.save(new User(name, lastName, age)));
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.delete(session.get(User.class, id));
                session.getTransaction().commit();

            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        return todo(session -> session.createQuery("from User").getResultList());
    }

    @Override
    public void cleanUsersTable() {
        todo(session -> session.createQuery("delete User").executeUpdate());
    }
}
