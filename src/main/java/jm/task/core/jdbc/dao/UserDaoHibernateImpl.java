package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = openTransactionSession()) {
            String SQL = "CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45) " +
                    "NOT NULL, lastname VARCHAR(45) NOT NULL, age TINYINT NOT NULL, PRIMARY KEY (id)) " +
                    "ENGINE = InnoDB DEFAULT CHARACTER SET = utf8";
            session.createSQLQuery(SQL).executeUpdate();
            closeTransactionSession();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = openTransactionSession()) {
            String SQL = "DROP TABLE if EXISTS users";
            session.createSQLQuery(SQL).executeUpdate();
            closeTransactionSession();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = openTransactionSession()) {
            session.save(new User(name, lastName, age));
            closeTransactionSession();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = openTransactionSession()) {
            session.createQuery("delete User where id = :id").setParameter("id", id).executeUpdate();
            closeTransactionSession();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = openTransactionSession()) {
            List<User> userList = session.createQuery("from User").getResultList();
            closeTransactionSession();
            return userList;
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = openTransactionSession()) {
            session.createQuery("delete User").executeUpdate();
            closeTransactionSession();
        }
    }
}
