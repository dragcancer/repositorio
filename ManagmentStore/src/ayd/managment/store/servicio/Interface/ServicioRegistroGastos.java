package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Gasto;
import ayd.managment.store.persistencia.Intercafe.DAOGasto;

public interface ServicioRegistroGastos{
	//void servicioRegistroGasto(DAOGasto daoGasto);
	void inicia();
	boolean agregaGasto(Gasto gasto);
}

