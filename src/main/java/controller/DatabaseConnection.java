package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5804907?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "sql5804907";
    private static final String PASSWORD = "HiWWeMp8p3V";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a FreeSQLDatabase.com");

            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS persona (" +
                             "nombre VARCHAR(100) PRIMARY KEY," +
                             "edad INT)";
                stmt.execute(sql);
                System.out.println("✅ Tabla 'persona' creada o ya existente.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al conectar o crear tabla:");
            e.printStackTrace();
        }
        return conn;
    }
}
