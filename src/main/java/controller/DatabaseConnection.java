package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
        "jdbc:mysql://gondola.proxy.rlwy.net:56194/railway"
        + "?sslMode=REQUIRED"
        + "&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "iRvUaaLhNMEYLmYQbmWuNbOOKoqxDvO";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL Railway");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
