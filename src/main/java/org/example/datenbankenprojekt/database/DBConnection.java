package org.example.datenbankenprojekt.database;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/DB";
    private static final String USER = "YOUR USERNAME!!";
    private static final String PASSWORD = "YOUR PASSWORD!!";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}