package bean.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.connection.Conexion;
import bean.interfac.ICliente;
import bean.modelo.Cliente;

public class ClienteImpl implements ICliente<Cliente, Integer> {

	private Connection connection;
	private PreparedStatement preQuery;
	private boolean isSuccesfully = false;
	private Cliente cliente;
	private ArrayList<Cliente> clientes;

	private final String[] QUERIES = {
			"INSERT INTO cliente (id, nombres, apellidos, telefono, ciudad) VALUES ( ? , ? , ? , ? , ? )",
			"SELECT * FROM cliente WHERE id = ?;",
			"UPDATE cliente SET id = ?, nombres = ? , apellidos = ? , telefono = ? , ciudad = ? WHERE (id = ?);",
			"DELETE FROM cliente WHERE (id = ?);", "SELECT * FROM cliente;" };

	public ClienteImpl() {
		super();
		connection = Conexion.getInstance().getConnection();
		cliente = new Cliente();
		clientes = new ArrayList();
	}

	@Override
	public ArrayList<Cliente> listaRegistros() {
		// TODO Auto-generated method stub
		try {
			preQuery = connection.prepareStatement(QUERIES[4]);
			ResultSet data = preQuery.executeQuery();

			while (data.next()) {
				clientes.add(new Cliente(data.getInt("id"), data.getString("nombres"), data.getString("apellidos"),
						data.getString("telefono"), data.getString("ciudad")));
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return clientes;
	}

	@Override
	public boolean crearRegistro(Cliente model) {
		// TODO Auto-generated method stub
		try {
			preQuery = connection.prepareStatement(QUERIES[0]);

			preQuery.setInt(1, model.getId());
			preQuery.setString(2, model.getNombres());
			preQuery.setString(3, model.getApellidos());
			preQuery.setString(4, model.getTelefono());
			preQuery.setString(5, model.getCiudad());

			// Mostrar la consulta completa en pantalla
			System.out.println(preQuery);

			if (preQuery.executeUpdate() > 0) {
				isSuccesfully = true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isSuccesfully;
	}

	@Override
	public Cliente obtenerRegistro(Integer idModel) {
		// TODO Auto-generated method stub
		try {
			preQuery = connection.prepareStatement(QUERIES[1]);
			preQuery.setInt(1, idModel);
			ResultSet data = preQuery.executeQuery();

			if (data.next()) {
				cliente.setId(data.getInt("id"));
				cliente.setNombres(data.getString("nombres"));
				cliente.setApellidos(data.getString("apellidos"));
				cliente.setTelefono(data.getString("telefono"));
				cliente.setCiudad(data.getString("ciudad"));
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return cliente;
	}

	@Override
	public boolean actualizarRegistro(Cliente model, Integer idModel) {
		// TODO Auto-generated method stub
		try {
			preQuery = connection.prepareStatement(QUERIES[2]);
			preQuery.setInt(1, model.getId());
			preQuery.setString(2, model.getNombres());
			preQuery.setString(3, model.getApellidos());
			preQuery.setString(4, model.getTelefono());
			preQuery.setString(5, model.getCiudad());
			preQuery.setInt(6, idModel);

			// Mostrar la consulta completa en pantalla
			System.out.println(preQuery);

			if (preQuery.executeUpdate() > 0) {
				isSuccesfully = true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isSuccesfully;
	}

	@Override
	public boolean eliminarRegistro(Integer idModel) {
		// TODO Auto-generated method stub
		try {
			preQuery = connection.prepareStatement(QUERIES[3]);
			preQuery.setInt(1, idModel);

			// Mostrar la consulta completa en pantalla
			System.out.println(preQuery);

			if (preQuery.executeUpdate() > 0) {
				isSuccesfully = true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isSuccesfully;
	}

}
