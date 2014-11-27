package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;
import ayd.managment.store.servicio.Interface.ServicioActualizacionUsuario;
import ayd.managment.store.vista.VentanaActualizacionUsuario;



public class ServicioActualizacionUsuarioClase implements ServicioActualizacionUsuario{
	private DAOUsuario daousuario;
	private Usuario usuario;
	private VentanaActualizacionUsuario obventanausuario= new VentanaActualizacionUsuario(this);
	
	//inicializa el DAOUsuario
	public void servicioActualizacionUsuario(DAOUsuario daoUsuario){
		this.daousuario = daoUsuario;	
	}

	//inicia la ventanaActualizacion usuario
	public void inicia(){
		obventanausuario.setVisible(true);
	}
	
	//regresa el usuario del identificador
	public String[] buscaId(String id_emp){
		String[] arregloUsuario= new String[15];
		usuario=daousuario.retriveUsuario(id_emp);
		arregloUsuario[0]=usuario.getApellidoPaterno();
		arregloUsuario[1]=usuario.getApellidoMaterno();
		arregloUsuario[2]=usuario.getNombre();
		arregloUsuario[3]=usuario.getCalle();
		arregloUsuario[4]=""+usuario.getNumeroExterior();
		arregloUsuario[5]=""+usuario.getNumeroInterior();
		arregloUsuario[6]=usuario.getColonia();
		arregloUsuario[7]=usuario.getMunicipio();
		arregloUsuario[8]=usuario.getCalle();
		arregloUsuario[9]=""+usuario.getCodigoPostal();
		arregloUsuario[10]=usuario.getTelefono();
		arregloUsuario[11]=usuario.getCodigoEmpleado();
		arregloUsuario[12]=usuario.getPassword();
		arregloUsuario[13]=usuario.getPassword();
		arregloUsuario[14]=""+usuario.getTipoUsuario();
		return arregloUsuario;
	}
	
	//manda al dao los datos nuevos del empleado
	public boolean actualizaEmpleado(String codigoEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, int numeroExterior, int numeroInterior, String colonia, String municipio, int codigoPostal, String telefono, int tipoUsuario, String password){
		usuario.setCodigoEmpleado(codigoEmpleado);
		usuario.setNombre(nombre);
		usuario.setApellidoPaterno(apellidoPaterno);
		usuario.setApellidoMaterno(apellidoMaterno);
		usuario.setCalle(calle);
		usuario.setNumeroExterior(numeroExterior);
		usuario.setNumeroInterior(numeroInterior);
		usuario.setColonia(colonia);
		usuario.setMunicipio(municipio);
		usuario.setCodigoPostal(codigoPostal);
		usuario.setTelefono(telefono);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setPassword(password);
		return daousuario.update(usuario);
	}
}