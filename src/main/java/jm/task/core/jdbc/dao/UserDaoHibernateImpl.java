package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;



public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }
//    public static final Session session = Util.getSession();

    @Override
    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users (" +
//                "id SERIAL PRIMARY KEY, " +
//                "name VARCHAR(128)," +
//                "lastName VARCHAR(128)," +
//                "age TINYINT)";
//        Transaction transaction = session.getTransaction();
//        try {
//            transaction.begin();
//            session.createQuery(sql,User.class);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//        transaction.commit();
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
