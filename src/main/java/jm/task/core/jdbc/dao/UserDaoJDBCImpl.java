package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public static final Connection connection = Util.getConnection();

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(128)," +
                    "lastName VARCHAR(128)," +
                    "age TINYINT)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String text = "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement prepStat = connection.prepareStatement(text)) {
            prepStat.setString(1, name);
            prepStat.setString(2, lastName);
            prepStat.setByte(3, age);
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        String text = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(text)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT name,lastName,age FROM Users");
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString("name");
                String userLastName = rs.getString("lastName");
                Byte userAge = rs.getByte("age");
                User user = new User(userName, userLastName, userAge);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
