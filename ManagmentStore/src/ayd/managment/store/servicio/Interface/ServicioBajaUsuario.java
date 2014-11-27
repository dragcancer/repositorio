package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;

public interface ServicioBajaUsuario {
	public void servicioBajaUsuario(DAOUsuario daoUsuario);
	public void inicia();
	public boolean BajaUsuario(String id);
	public Usuario buscarUsuario(String codigoUsuario);
}
