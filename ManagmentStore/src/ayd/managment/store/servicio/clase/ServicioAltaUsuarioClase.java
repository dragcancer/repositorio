package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;
import ayd.managment.store.servicio.Interface.ServicioAltaUsuario;
import ayd.managment.store.vista.VentanaAltaUsuario;

public class ServicioAltaUsuarioClase implements ServicioAltaUsuario{
	//Variables de clase
	private DAOUsuario daoUsuario;
	private Usuario usuario;
	private VentanaAltaUsuario ventana = new VentanaAltaUsuario(this);
	
	//Recibe el daoUsuario
	public void servicioAltaUsuario(DAOUsuario daoUsuario){
		this.daoUsuario = daoUsuario;
	}
	
	//Inicia la ventana de actualizacion de productos
	public void inicia(){
	    ventana.setVisible(true);
	}
	
	//Busca un usuario utilizado 3 criterios, nombre y apellidos, regresa un false si 
	//el usuario no fue encontrado, true en otro caso
	private boolean buscaUsuario(String nombre, String apellidoP, String apellidoM){
		Usuario usuario = daoUsuario.buscaUsuarioAlta(nombre, apellidoP, apellidoM);
		
		if(usuario != null)
			return true;
		else
			return false;
	}
	
	//Recibe los datos de un usuario para guardar sus datos
	//regresa un entero 1 si la operacion fue exitosa, 0 si fallo la operacion por que el usuario ya existe 
	//2 por fallo en la operacion al tratar de guardar los nuevos datos
	public int guardaUsuario(String[] datos){
		int nume = 0 ,numi = 0,codigop = 0,tipo = 0;
		String colonia = "";
		if(buscaUsuario(datos[1], datos[2], datos[3]))
			return 0;
		else{
			try{
				nume = Integer.parseInt(datos[5]);
				codigop = Integer.parseInt(datos[9]);
				tipo = Integer.parseInt(datos[11]);
				if(datos[6].isEmpty())	
					numi = -1;
				else
					numi = Integer.parseInt(datos[6]);
				if(!datos[7].isEmpty())
					colonia = datos[7];
			}catch(NumberFormatException ex){
			}
			usuario = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], nume, numi, colonia, datos[8], codigop, datos[10], tipo, datos[12]);
			if(daoUsuario.createUsuario(usuario))
				return 1;
			else
				return 2;
		}
	}
}
