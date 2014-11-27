package ayd.managment.store.servicio.clase;
import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;
import ayd.managment.store.servicio.Interface.ServicioLogin;
import ayd.managment.store.vista.VentanaLogin;
import ayd.managment.store.vista.VentanaPrincipal;
import ayd.managment.store.vista.VentanaProductos;
import ayd.managment.store.vista.VentanaProveedores;
import ayd.managment.store.vista.VentanaUsuarios;
import ayd.managment.store.vista.VentanaGenerarReportes;

public class ServicioLoginClase implements ServicioLogin{

	private VentanaPrincipal ventanaPrincipal;
	private VentanaProductos ventanaProductos;
	private VentanaProveedores ventanaProveedores;
	private VentanaUsuarios ventanaUsuarios;
	private VentanaGenerarReportes ventanaGenerarReportes;
	private DAOUsuario daoUsuario;
	private VentanaLogin ventana = new VentanaLogin(this);
	private int respuesta;
	private int intentos = 0;
	private int intentospermitidos = 2;
	//Constructor con referencia a VentanaPrincipal,VentanaProductos,VentanaUsuarios,VentanaGenerarReportes y DAOUsuario.
	public void servicioLogin(VentanaPrincipal ventanaPrincipal, VentanaProductos ventanaProductos,
			VentanaUsuarios ventanaUsuarios, VentanaProveedores ventanaProveedores, VentanaGenerarReportes ventanaGenerarReportes, DAOUsuario daoUsuario){
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaProductos = ventanaProductos;
		this.ventanaProveedores = ventanaProveedores;
		this.ventanaUsuarios = ventanaUsuarios;
		this.ventanaGenerarReportes = ventanaGenerarReportes;
		this.daoUsuario = daoUsuario;
		bloqueaVentanaPrincipal();
	}
	//Inicia la ventana de login.
	public void inicia(int numeroBoton){
		ventana.setVisible(true);
		ventana.setAlwaysOnTop(true);
		ventana.setLocationRelativeTo(null);
		respuesta = numeroBoton;
	}
	//Metodo que busca el usuario en la base de datos y/o verifica su existencia asi como que haya usuarios registrados.
	public int Login(String codigoEmpleado,String password){
		Usuario u = null;

		if(daoUsuario.cuantosUsuarios()!=0){
			u = daoUsuario.retriveUsuario(codigoEmpleado);
			return ValidaUsuario(password,u);
		}
		return 3;
	}
	//Metodo que valida el tipo del usuario y su contrasena
	//Si el tipo del usuario es 1 significa que es administrador(regla de negocio).
	public int ValidaUsuario(String password,Usuario U){
		if(U != null){
			if((U.getTipoUsuario()==1) && (U.getPassword().equals(password))){
				switch(respuesta){
				case 1: ventanaProductos.setVisible(true);
						break;
				case 2: ventanaUsuarios.setVisible(true);
						break;
				case 3: ventanaGenerarReportes.setVisible(true);
						break;
				case 4: ventanaProveedores.setVisible(true);
						break;
				}
				return 0;                     
			}
			else{
				if(U.getTipoUsuario() != 1){
					return 1;
				}
				else
					return 2;
			}			
		}
		else
			return 3;
	}
	
	//Regresa el numero de intentos para hacer login.
	public int getIntentos() {
		return intentos;
	}
	
	//Cambia el numero de intentos.
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	//Regresa el numero de intentos permitidos para hacer login.
	public int getIntentospermitidos() {
		return intentospermitidos;
	}
	
	//Metodo que bloquea la ventana principal hasta que la ventana login se cierre o permita el acceso al usuario
	public void bloqueaVentanaPrincipal(){
		ventanaPrincipal.setEnabled(false);
	}
	
	//Metodo que desbloquea la ventana principal una ves que la ventana de login se cerro o que permitio el acceso al usuario.
	public void desbloqueaVentanaPrincipal(){
		ventanaPrincipal.setEnabled(true);
	}
	
	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

}