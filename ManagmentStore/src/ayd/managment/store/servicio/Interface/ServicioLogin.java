package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;
import ayd.managment.store.vista.VentanaGenerarReportes;
import ayd.managment.store.vista.VentanaPrincipal;
import ayd.managment.store.vista.VentanaPrincipalAdmin;
import ayd.managment.store.vista.VentanaProductos;
import ayd.managment.store.vista.VentanaProveedores;
import ayd.managment.store.vista.VentanaUsuarios;

public interface ServicioLogin {
	public void servicioLogin(VentanaPrincipal ventanaPrincipal, VentanaProductos ventanaProductos,
			VentanaUsuarios ventanaUsuarios,  VentanaProveedores ventanaProveedores, VentanaGenerarReportes ventanaGenerarReportes, DAOUsuario daoUsuario, VentanaPrincipalAdmin ventanaPrincipalAdmin);	
	public void inicia(int numeroBoton);
	public int Login(String codigoEmpleado,String password);
	public int ValidaUsuario(String password,Usuario U);
	public int getIntentos();
	public void setIntentos(int intentos);
	public int getIntentospermitidos();
	public void bloqueaVentanaPrincipal();
	public void desbloqueaVentanaPrincipal();
}