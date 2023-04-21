package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 20);
        userDaoJDBC.saveUser("Petr", "Petrov", (byte) 21);
        userDaoJDBC.saveUser("Andrey", "Andreev", (byte) 22);
        userDaoJDBC.saveUser("Vasya", "Vasylev", (byte) 23);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
        Util.closeConnection();
    }
}
