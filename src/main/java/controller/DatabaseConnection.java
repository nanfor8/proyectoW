package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {

        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (url == null || user == null || password == null) {
            throw new SQLException("Missing DB env vars. Required: DB_URL, DB_USER, DB_PASSWORD");
        }

        // PostgreSQL JDBC driver se auto-registra (no necesitas Class.forName).
        return DriverManager.getConnection(url, user, password);
    }
}
