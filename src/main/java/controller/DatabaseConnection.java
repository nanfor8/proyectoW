package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://brz591l3z0lepartaljr-mysql.services.clever-cloud.com:3306/brz591l3z0lepartaljr?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "urbxesinzl102ykx";
    private static final String PASSWORD = "iqGuk1NpYRNatGsIpMoo";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("⚠️ Error al conectar con la base de datos:");
            e.printStackTrace();
            return null;
        }
    }
}
