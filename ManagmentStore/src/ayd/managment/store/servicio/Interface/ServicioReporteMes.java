package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Venta;

public interface ServicioReporteMes {
	public void inicia();
	public Venta[] generarReporte(String mes, String anio);
}
