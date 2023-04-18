package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Geey","Trew", (byte) 23);
//        userDaoJDBC.cleanUsersTable();
//        userDaoJDBC.removeUserById(3);
        System.out.println(userDaoJDBC.getAllUsers());
    }

}
