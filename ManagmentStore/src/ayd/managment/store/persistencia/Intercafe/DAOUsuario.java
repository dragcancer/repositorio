package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.Usuario;

public interface DAOUsuario {
	public boolean createUsuario(Usuario usuario);
	public Usuario buscaUsuarioAlta(String nombre, String apellidoP, String apellidoM);
	public boolean Delete(String id);
	public Usuario retriveUsuario(String codigoEmpleado);
	public int cuantosUsuarios();
	public boolean update(Usuario usuario);
}
