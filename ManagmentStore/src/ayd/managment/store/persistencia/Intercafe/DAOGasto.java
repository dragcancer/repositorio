package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.Gasto;

public interface DAOGasto {
	public boolean create(Gasto gasto);
	public Gasto[] retriveGastos();
	public int cuantosGastos();
	public Gasto[] retriveGastosDelMes(String fechaIni,String fechaFin);
}
