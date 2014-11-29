package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;

public interface ServicioGenerarPedido {
	public void servicioGenerarPedido(DAOProducto  daoProducto);
	public void inicia();
	public String[] regresaProveedores();
	public Producto[] productosProveedor(String proveedor);
	public boolean generarPdf(String[] productos, String[] cantidad);
}
