package bean.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	// Instancia de la clase
	private static Conexion connectInstance;
	// Variable para realizar la conexi�n
	private Connection connection;
	// Nombre de usuario autorizado para conectarse
	private final String USER = "postgres";
	// Contrase�a para conectarnos
	private final String PASSWORD = "10496";
	// Nombre Base de Datos
	private final String DATABASE = "Prueba";
	// Direcci�n y nombre de la bd conectarnos
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

	// Implementaci�n del patr�n singleton para acceder a una instancia �nica de la
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
