package bean.factory;

import bean.implement.ClienteImpl;
import bean.interfac.ICliente;

public class Factory {

	public enum DaoType {
		CLIENTE,
	}
	
	public static ICliente getCliente(DaoType daoType) {
		ICliente dao = null;
		switch (daoType) {
		case CLIENTE:
			dao = new ClienteImpl();
			break;
		}
		return dao;
	}
}
