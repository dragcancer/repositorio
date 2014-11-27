package ayd.managment.store.servicio.Interface;

import java.util.ArrayList;

import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;

public interface ServicioVentas {
	public void servicioVentas(DAOVenta daoVenta,DAOProducto daoProducto);
	public void inicia();
	public boolean buscarProductoNombre(String nombre);
	public boolean buscarProductoCodigo(String codigo);
	public String[] mostrarDatos();
	public ArrayList<String[]>  mostrarDatosLista();
	public int realizarVenta(ArrayList<String[]> productos);
	public float muestraTotal();
	public boolean guardarVenta();
	public boolean guardarVentaPDF();
}
