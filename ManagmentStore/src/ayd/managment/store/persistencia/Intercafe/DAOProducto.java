package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.Producto;

public interface DAOProducto {
	public boolean create(Producto producto);
	public Producto retriveCodigo(String codigo);
	public Producto retriveNombre(String nombre);
	public Producto[] retriveNombreParcial(String nombre);
	public boolean updateActualizacion(Producto producto);
	public boolean updateVenta(Producto producto);
	public boolean delete(Producto producto);
	public int cuantosProductos();
	public String[] proveedores();
	public Producto[] buscaProductosProveedor(String proveedor);
	public Producto[] retriveAll();
	public boolean updateProductos(Producto[] productos);
}
