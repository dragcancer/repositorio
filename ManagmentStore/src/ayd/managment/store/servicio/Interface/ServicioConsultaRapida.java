package ayd.managment.store.servicio.Interface;

import java.util.ArrayList;

import ayd.managment.store.persistencia.Intercafe.DAOProducto;

public interface ServicioConsultaRapida {
	public void servicioConsultaRapida(DAOProducto daoProducto);
	public void inicia();
	public int buscarProducto(String criterio);
	public boolean buscarProductoCodigo(String codigo);
	public boolean buscarProductoNombre(String nombre);
	public String[] mostrarDatos();
	public ArrayList<String[]>  mostrarDatosLista();
}
