package ayd.managment.store.servicio.clase;

import java.util.ArrayList;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.persistencia.clase.DAOProductoClase;
import ayd.managment.store.servicio.Interface.ServicioGenerarPedido;
import ayd.managment.store.vista.VentanaGenerarPedido;

public class ServicioGenerarPedidoClase implements ServicioGenerarPedido{
	
	
	private DAOProducto daoProducto = new DAOProductoClase();
	private VentanaGenerarPedido ventana = new VentanaGenerarPedido(this);
	
	
	public void servicioGenerarPedido(DAOProducto  daoProducto){
		this.daoProducto = daoProducto;
	}
	
	// Muestra ventana de GenerarPedido
	public void inicia(){
			ventana.setVisible(true);
			ventana.carga_ComboProveedor();
	}
	
	// Regresa todos los proveedores registrados
	public String[] regresaProveedores(){
		return daoProducto.proveedores();
	}
	
	// Regresa todos los productos de baja existencia del proveedor que se le pase como parametro
	public Producto[] productosProveedor(String proveedor){
		Producto[] productosP = daoProducto.buscaProductosProveedor(proveedor);
		ArrayList<Producto> bajaExistencia = new ArrayList<Producto>();
		Producto[] existenciaBajaProductos = null;
		for(Producto producto: productosP)
			if(producto.getExistenciaActual() <= producto.getExistenciaMinima()){
				bajaExistencia.add(producto);
			}	
		if (bajaExistencia.size() != 0){
			existenciaBajaProductos = new Producto[bajaExistencia.size()];
			bajaExistencia.toArray(existenciaBajaProductos);
		}
		return existenciaBajaProductos;
	}

}

