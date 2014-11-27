package ayd.managment.store.servicio.Interface;

import ayd.managment.store.persistencia.Intercafe.DAOProducto;

public interface ServicioActualizacionProducto {
	public void servicioActualizacionProducto(DAOProducto daoProducto);
	public void inicia();
	public boolean buscarProducto(String criterio);
	public String[] mostrarDatos();
	public boolean validarValores(String[] datos);
	public boolean actualizarProducto();
}
