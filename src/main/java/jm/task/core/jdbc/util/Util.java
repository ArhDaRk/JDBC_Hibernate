package jm.task.core.jdbc.util;


import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private Util() {
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ----------------------------------------------
//    public static Session getSession() {
//        Configuration configuration = new Configuration();
//        configuration.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
//        configuration.setProperty("hibernate.connection.url", URL);
//        configuration.setProperty("hibernate.connection.username", USERNAME);
//        configuration.setProperty("hibernate.connection.password", PASSWORD);
//        configuration.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//        configuration.setProperty("show_sql", "true");
//        configuration.addAnnotatedClass(User.class);
//        return configuration.buildSessionFactory().openSession();
//    }


}


