package com.victortello.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/javaee";
    private static String user = "root";
    private static String pass = "linuxx";
    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, pass);                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;

    }

}
