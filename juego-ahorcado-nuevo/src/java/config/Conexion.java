package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/DB_JuegoAhorcado?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "quintom"; 
            String password = "admin";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException error) {
            System.out.println("Error: No se encontró el driver de MySQL");
            error.printStackTrace();
        } catch (SQLException error) {
            System.out.println("Error de conexión a la base de datos");
            error.printStackTrace();
        }
        return conexion;
    }
}
