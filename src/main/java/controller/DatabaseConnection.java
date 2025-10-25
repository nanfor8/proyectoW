package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://mysql-2dcd634a-nanfor8-ba72.f.aivencloud.com:12016/defaultdb";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_AR1pXMkx4vHFn67C6uD";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Propiedades para conexión segura con SSL
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("sslMode", "REQUIRED");
            props.setProperty("enabledTLSProtocols", "TLSv1.2,TLSv1.3");

            Connection conn = DriverManager.getConnection(URL, props);

            if (conn != null) {
                System.out.println("✅ Conexión exitosa a la base de datos Aiven.");
            } else {
                System.out.println("⚠️ No se pudo establecer la conexión (conn es null).");
            }

            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: no se encontró el driver JDBC.");
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            System.out.println("❌ Error SQL al conectar con Aiven:");
            e.printStackTrace();
            return null;
        }
    }
}
