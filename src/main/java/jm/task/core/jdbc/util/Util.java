package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Util {
    private static final String URL ="jdbc:mysql://localhost:3306/mydbtest";
    private static final  String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Util () {
    }

    public static void doSomething (String sqlReqvest) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(sqlReqvest);
        }
    }
    public static List <User> getUserList () throws SQLException {
        List list = new LinkedList();
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT name,lastName,age FROM User");
            while (rs.next()) {
//                int id = rs.getInt("id");
                String userName = rs.getString("name");
                String userLastName = rs.getString("lastName");
                Byte userAge = rs.getByte("age");
                User user = new User(userName,userLastName,userAge);
                list.add(user);
            }
        }
        return list;
    }
}
