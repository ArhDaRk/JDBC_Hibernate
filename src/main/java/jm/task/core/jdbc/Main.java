package jm.task.core.jdbc;


import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Util.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
