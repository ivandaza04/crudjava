package bean.control;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bean.factory.Factory;
import bean.interfac.ICliente;
import bean.modelo.Cliente;

@Named
@SessionScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
	private Cliente cliente;
	private ICliente daocliente = Factory.getCliente(Factory.DaoType.CLIENTE);

	public ClienteBean() {
		// TODO Auto-generated constructor stub
		setCliente(new Cliente());
		clienteList = daocliente.listaRegistros();
	}

	public String agregarCliente() {
		System.out.println("----------Agregar----------" + cliente.toString());
		daocliente.crearRegistro(cliente);
		clienteList.add(cliente);
		cliente = new Cliente();
		return "index";
	}

	public void editarCliente(Cliente cliente) {
		cliente.setEditar(true);
		System.out.println("----------Editar----------" + cliente.toString());
	}

	public void guardarCliente(Cliente cliente) {
		cliente.setEditar(false);
		System.out.println("----------Guardar----------" + cliente.toString());
		daocliente.actualizarRegistro(cliente, cliente.getId());
	}

	public void eliminaCliente(Cliente cliente) {
		System.out.println("----------Eliminar----------" + cliente.toString());
		clienteList.remove(cliente);
		daocliente.eliminarRegistro(cliente.getId());
	}

	public ArrayList<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(ArrayList<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
