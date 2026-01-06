package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {

        // 🔥 MARCA DE AGUA (para saber si este archivo es el que corre en Render)
        System.out.println("=== DB CONNECTION VERSION: POSTGRES-NEON-2026-01-06 ===");

        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (url == null || user == null || password == null) {
            throw new SQLException("Missing DB env vars. Required: DB_URL, DB_USER, DB_PASSWORD");
        }

        // Debug seguro
        System.out.println("DB_URL=" + url);
        System.out.println("DB_USER=" + user);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found in classpath.", e);
        }

        return DriverManager.getConnection(url, user, password);
    }
}

        return DriverManager.getConnection(url, user, password);
    }
}

