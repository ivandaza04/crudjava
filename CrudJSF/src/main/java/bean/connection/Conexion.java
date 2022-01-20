package bean.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	// Instancia de la clase
	private static Conexion connectInstance;
	// Variable para realizar la conexión
	private Connection connection;
	// Nombre de usuario autorizado para conectarse
	private final String USER = "postgres";
	// Contraseña para conectarnos
	private final String PASSWORD = "10496";
	// Nombre Base de Datos
	private final String DATABASE = "Prueba";
	// Dirección y nombre de la bd conectarnos
	private final String URL = "jdbc:postgresql://localhost:5432/" + DATABASE;

	private Conexion() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado!");
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			System.out.println("OK ");
		}
	}

	// Implementación del patrón singleton para acceder a una instancia única de la
	// clase
	public static Conexion getInstance() {
		if (connectInstance == null) {
			connectInstance = new Conexion();
		}
		return connectInstance;
	}

	public Connection getConnection() {
		return connection;
	}
}
