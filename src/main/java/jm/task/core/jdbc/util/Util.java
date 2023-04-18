package jm.task.core.jdbc.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Util() {
    }

    public static void doSomething(String sqlReqvest) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(sqlReqvest);
        }
    }

    public static <T> List<T> getList(String sql, Function<ResultSet, T> function) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                list.add(function.apply(rs));
            }
            return list;
        }

    }
}
