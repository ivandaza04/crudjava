package bean.interfac;

import java.util.ArrayList;

public interface ICliente<T, V> {

	// declaración de métodos para acceder a la base de datos
	public ArrayList<T> listaRegistros();

	public boolean crearRegistro(T model);

	public T obtenerRegistro(V idModel);

	public boolean actualizarRegistro(T model, V idModel);

	public boolean eliminarRegistro(V idModel);
}
