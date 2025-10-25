package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://mysql-2dcd634a-nanfor8-ba72.f.aivencloud.com:12016/defaultdb?useSSL=true&requireSSL=true&verifyServerCertificate=false&serverTimezone=UTC";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_AR1pXMkx4vHFn67C6uD";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL remoto (Aiven)");
            // Crear tabla si no existe
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS persona (" +
                             "nombre VARCHAR(100) PRIMARY KEY," +
                             "edad INT)";
                stmt.execute(sql);
                System.out.println("✅ Tabla 'persona' creada o ya existente.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ No se encontró el driver MySQL JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con MySQL remoto:");
            e.printStackTrace();
        }
        return conn;
    }
}
