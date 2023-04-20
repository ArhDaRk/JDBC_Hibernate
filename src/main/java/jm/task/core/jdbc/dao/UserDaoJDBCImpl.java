package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS user (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(128)," +
                    "lastName VARCHAR(128)," +
                    "age TINYINT)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String text = String.format("INSERT INTO user(name, lastName, age) VALUES ('%s','%s',%s)", name, lastName, age);
        try (Statement statement = getConnection().createStatement()) {
            statement.execute(text);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        String text = String.format("DELETE FROM user WHERE id = %s", id);
        try (Statement statement = getConnection().createStatement()) {
            statement.execute(text);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try (Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT name,lastName,age FROM User");
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString("name");
                String userLastName = rs.getString("lastName");
                Byte userAge = rs.getByte("age");
                User user = new User(userName,userLastName,userAge);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void cleanUsersTable() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("DELETE FROM user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
