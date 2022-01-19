package bean.control;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SaludoBean {

	private String saludo = "Hola bienvenidos";
	private String nombre;

	public void saludarPersona() {
		String saludoNuevo = "Un gusto saludarlo "+getSaludo()+ " fin";
		setSaludo(saludoNuevo);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
}
