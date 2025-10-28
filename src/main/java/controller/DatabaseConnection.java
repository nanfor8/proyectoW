package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://brz591l3z0lepartaljr-mysql.services.clever-cloud.com:3306/brz591l3z0lepartaljr?useSSL=true&requireSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "urbxesinzl102ykx";
    private static final String PASSWORD = "iqGuk1NpYRNatGsIpMoo";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conectado exitosamente a la base de datos Clever Cloud.");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
