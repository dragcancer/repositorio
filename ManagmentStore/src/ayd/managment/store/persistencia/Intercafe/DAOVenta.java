package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.Venta;

public interface DAOVenta {
	public boolean create(Venta venta);
	public Venta[] retriveVentasDelDia(String fecha);
	public int cuantasVentas();
	public Venta[] retriveVentasDelMes(String fechaIni,String fechaFin);
}
