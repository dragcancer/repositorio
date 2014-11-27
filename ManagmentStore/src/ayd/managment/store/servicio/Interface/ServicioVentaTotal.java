package ayd.managment.store.servicio.Interface;

import java.util.ArrayList;

import ayd.managment.store.persistencia.Intercafe.DAOHistorial;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;

public interface ServicioVentaTotal {
	public void servicioVentaTotal(DAOVenta daoVenta, DAOHistorial daoHistorial);
	public void inicia();
	public boolean buscarVentas();
	public ArrayList<String[]>  mostrarDatosLista();
	public boolean calcularVentas(ArrayList<String> ventas);
	public float muestraTotal();
	public boolean guardaEnHistorial();
}
