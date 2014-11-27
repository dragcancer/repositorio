package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;
import ayd.managment.store.servicio.Interface.ServicioBajaUsuario;
import ayd.managment.store.vista.VentanaBajaUsuario;

public class ServicioBajaUsuarioClase implements ServicioBajaUsuario{
	private DAOUsuario daoUsuario;
	private VentanaBajaUsuario ventana = new VentanaBajaUsuario(this);
	private Usuario usuario;
	
	public void servicioBajaUsuario(DAOUsuario daoUsuario){
		this.daoUsuario= daoUsuario;
	}
	
	//Inicia la ventana de actualizacion de productos
	public void inicia(){
	    ventana.setVisible(true);
	}

	public boolean BajaUsuario(String id){
		boolean res=false;
		//cacho el resultado de la funcion en una variable
		boolean usuariores=daoUsuario.Delete(id);
		if(usuariores==true){
			res=true;
		}			//regreso true
		return res;
	}
	
	public Usuario buscarUsuario(String codigoUsuario) {
		//boolean encontrado=false;
		usuario =  daoUsuario.retriveUsuario(codigoUsuario);
		
		if (usuario!=null){		
			return usuario;
		}
		return usuario;
	}
}
