package ayd.managment.store.servicio.Interface;

import ayd.managment.store.persistencia.Intercafe.DAOUsuario;

public interface ServicioActualizacionUsuario {
	public void servicioActualizacionUsuario(DAOUsuario daoUsuario);
	public void inicia();
	public String[] buscaId(String id_emp);
	public boolean actualizaEmpleado(String codigoEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, int numeroExterior, int numeroInterior, String colonia, String municipio, int codigoPostal, String telefono, int tipoUsuario, String password);
}