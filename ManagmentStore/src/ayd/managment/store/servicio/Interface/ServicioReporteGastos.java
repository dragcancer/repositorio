package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Gasto;

public interface ServicioReporteGastos {
	public void inicia();
	public Gasto[] ConsultaGasto(String ini,String fin);
}
