package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Util.doSomething("CREATE TABLE IF NOT EXISTS user (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(128)," +
                    "lastName VARCHAR(128)," +
                    "age TINYINT)");
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        try {
            Util.doSomething("DROP TABLE IF EXISTS user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String text = String.format("INSERT INTO user(name, lastName, age) VALUES ('%s','%s',%s)",name,lastName,age);
        try {
            Util.doSomething(text);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User с именем – " + name  + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        String text = String.format("DELETE FROM user WHERE id = %s",id);
        try {
            Util.doSomething(text);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try {
            return Util.getUserList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try {
            Util.doSomething("DELETE FROM user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
