package ayd.managment.store.servicio.Interface;

import ayd.managment.store.persistencia.Intercafe.DAOUsuario;

public interface ServicioAltaUsuario {
	public void servicioAltaUsuario(DAOUsuario daoUsuario);
	public void inicia();
	public int guardaUsuario(String[] datos);
}
