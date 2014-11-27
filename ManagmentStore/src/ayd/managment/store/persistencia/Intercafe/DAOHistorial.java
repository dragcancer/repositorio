package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.Historial;

public interface DAOHistorial {
	public boolean create(Historial historial);
	public Historial retriveHistorial(String fecha);
	public boolean updateHistorial(Historial historial);
	public int cuantosHistoriales();
}
