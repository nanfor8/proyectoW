package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = 
        "jdbc:mysql://gondola.proxy.rlwy.net:56194/railway?useSSL=true&requireSSL=false&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "iRvUaaLhNMEYLmYQbmWuNbOOKoqxDvO";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
            return null;
        }
    }
}
