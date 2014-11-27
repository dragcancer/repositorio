package ayd.managment.store.servicio.Interface;

import ayd.managment.store.persistencia.Intercafe.DAOProducto;

public interface ServicioBajaProducto {
	public void servicioBajaProducto(DAOProducto daoProducto);
	public void inicia();
	public boolean buscarProducto(String criterio);
	public String[] mostrarDatos();
	public boolean darDeBajaProducto();
}
