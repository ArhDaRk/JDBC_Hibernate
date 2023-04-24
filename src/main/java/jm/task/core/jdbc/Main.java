package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl test = new UserServiceImpl(new UserDaoJDBCImpl());
        test.createUsersTable();
        test.saveUser("Ivan", "Ivanov", (byte) 20);
        test.saveUser("Petr", "Petrov", (byte) 21);
        test.saveUser("Andrey", "Andreev", (byte) 22);
        test.saveUser("Vasya", "Vasylev", (byte) 23);
        System.out.println(test.getAllUsers());
        test.cleanUsersTable();
        Util.closeConnection(UserDaoJDBCImpl.connection);
    }
}
