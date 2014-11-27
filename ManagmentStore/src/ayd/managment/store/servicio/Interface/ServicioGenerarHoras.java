package ayd.managment.store.servicio.Interface;

import java.util.ArrayList;

import ayd.managment.store.persistencia.Intercafe.DAODiaLaborado;

public interface ServicioGenerarHoras {
	public void servicioGenerarHorasClase(DAODiaLaborado daoDiaLaborado);
	public void inicia();
	public boolean buscarUsuario(String codigoEmpleado);
	public boolean buscarDiasLaborados(String idUsuario, String fechaLimite);
	public float calculaSalario(String pagoPorHoras);
	public ArrayList<String[]> muestraDiasLaborados(String idUsuario, String fechaLimite);
	public String generarFecha();
	public String generarFechaLimite(int Limite);
}
