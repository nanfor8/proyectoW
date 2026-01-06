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

        // Debug seguro (no imprime password)
        System.out.println("DB_URL=" + url);
        System.out.println("DB_USER=" + user);

        // Fuerza driver PostgreSQL (evita confusiones)
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found in classpath.", e);
        }

        return DriverManager.getConnection(url, user, password);
    }
}

