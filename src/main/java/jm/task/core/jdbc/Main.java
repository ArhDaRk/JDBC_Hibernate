package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        UserService test = new UserServiceImpl(new UserDaoJDBCImpl());
        test.createUsersTable();
        test.saveUser("Ivan", "Ivanov", (byte) 20);
        test.saveUser("Petr", "Petrov", (byte) 21);
        test.saveUser("Andrey", "Andreev", (byte) 22);
        test.saveUser("Vasya", "Vasylev", (byte) 23);
        System.out.println(test.getAllUsers());
        test.cleanUsersTable();
        test.dropUsersTable();
        Util.closeConnection(UserDaoJDBCImpl.connection);

        // ____________________________________________________________ //

        UserService test2 = new UserServiceImpl(new UserDaoHibernateImpl());
        test2.createUsersTable();
        test2.saveUser("Ivan", "Ivanov", (byte) 20);
        test2.saveUser("Petr", "Petrov", (byte) 21);
        test2.saveUser("Andrey", "Andreev", (byte) 22);
        test2.saveUser("Vasya", "Vasylev", (byte) 23);
        System.out.println(test2.getAllUsers());
        test2.cleanUsersTable();
        test2.dropUsersTable();
        Util.closeSessionFactory(UserDaoHibernateImpl.sessionFactory);
    }
}
