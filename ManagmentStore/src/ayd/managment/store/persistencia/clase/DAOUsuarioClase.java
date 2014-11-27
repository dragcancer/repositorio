package ayd.managment.store.persistencia.clase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;

public class DAOUsuarioClase implements DAOUsuario {
	MyDataAcces mda;
	public DAOUsuarioClase(MyDataAcces mda){
		this.mda= mda;
	}
	public DAOUsuarioClase(){

	}
	public boolean createUsuario(Usuario usuario){


			if(usuario.getNumeroInterior()==-1 || usuario.getColonia().equals("")){//null
				if(usuario.getNumeroInterior()==-1 && usuario.getColonia().equals("")){
					return mda.setQuery("insert into Usuario values ('"+usuario.getCodigoEmpleado()+"','"+usuario.getNombre()+"','"+usuario.getApellidoPaterno()+"','"+usuario.getApellidoMaterno()+"','"+usuario.getCalle()+"',"+usuario.getNumeroExterior()+",null,null,'"+usuario.getMunicipio()+"',"+usuario.getCodigoPostal()+",'"+usuario.getTelefono()+"',"+usuario.getTipoUsuario()+",'"+usuario.getPassword()+"')");	
				}
				else{
					if(usuario.getNumeroInterior()==-1){
					   return mda.setQuery("insert into Usuario values ('"+usuario.getCodigoEmpleado()+"','"+usuario.getNombre()+"','"+usuario.getApellidoPaterno()+"','"+usuario.getApellidoMaterno()+"','"+usuario.getCalle()+"',"+usuario.getNumeroExterior()+",null,'"+usuario.getColonia()+"','"+usuario.getMunicipio()+"',"+usuario.getCodigoPostal()+",'"+usuario.getTelefono()+"',"+usuario.getTipoUsuario()+",'"+usuario.getPassword()+"')");							
					}if(usuario.getColonia().equals("")){
						return mda.setQuery("insert into Usuario values ('"+usuario.getCodigoEmpleado()+"','"+usuario.getNombre()+"','"+usuario.getApellidoPaterno()+"','"+usuario.getApellidoMaterno()+"','"+usuario.getCalle()+"',"+usuario.getNumeroExterior()+","+usuario.getNumeroInterior()+",null,'"+usuario.getMunicipio()+"',"+usuario.getCodigoPostal()+",'"+usuario.getTelefono()+"',"+usuario.getTipoUsuario()+",'"+usuario.getPassword()+"')");	
				
					}
				}
			}
			else{
				return mda.setQuery("insert into Usuario values ('"+usuario.getCodigoEmpleado()+"','"+usuario.getNombre()+"','"+usuario.getApellidoPaterno()+"','"+usuario.getApellidoMaterno()+"','"+usuario.getCalle()+"',"+usuario.getNumeroExterior()+","+usuario.getNumeroInterior()+",'"+usuario.getColonia()+"','"+usuario.getMunicipio()+"',"+usuario.getCodigoPostal()+",'"+usuario.getTelefono()+"',"+usuario.getTipoUsuario()+",'"+usuario.getPassword()+"')");
			}
			return false;
	}
	
	public Usuario buscaUsuarioAlta(String nombre, String apellidoP, String apellidoM){
		Usuario usuario = null;
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM usuario WHERE nombre='"+nombre+"' AND apellidoPaterno='"+apellidoP+"' AND apellidoMaterno='"+apellidoM+"'");

			if(rs.next())
			//Crea una nueva instancia del objeto
			usuario = new Usuario(rs.getString("usuarioId"), rs.getString("nombre"), rs.getString("apellidoPaterno"), rs.getString("apellidoMaterno"), rs.getString("calle"), rs.getInt("numeroExterior"), rs.getInt("numeroInterior"), rs.getString("colonia"), rs.getString("municipio"), rs.getInt("codigoPostal"), rs.getString("telefono"), rs.getInt("tipoUsuario"), rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public boolean Delete(String id) {

			return mda.setQuery("DELETE FROM Usuario WHERE usuarioId='"+id+"'");
	}
	
	public Usuario retriveUsuario(String codigoEmpleado) {
		Usuario usuario = null;
		try {
			// Crea el statement
			
			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Usuario WHERE usuarioId='"+codigoEmpleado+"'");
				
			if(rs.next())
			// Crea una nueva instancia del objeto
				usuario = new Usuario(rs.getString("usuarioId"), rs.getString("nombre"),
						rs.getString("apellidoPaterno"), rs.getString("apellidoMaterno"),
						rs.getString("calle"), rs.getInt("numeroExterior"),
						rs.getInt("numeroInterior"), rs.getString("colonia"),
						rs.getString("municipio"), rs.getInt("codigoPostal"),
						rs.getString("telefono"), rs.getInt("tipoUsuario"),
						rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public int cuantosUsuarios() {
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT COUNT(*) FROM Usuario");
			if (rs.next()) 
		        return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//actualiza los datos que hayan sido cambiados del usuario
	public boolean update(Usuario usuario){
			// Crea el statement
		// actualiza los del usuario
			return mda.setQuery("UPDATE Usuario SET usuarioId='"+usuario.getCodigoEmpleado()+"', nombre='"+usuario.getNombre()+"', apellidoPaterno='"+usuario.getApellidoPaterno()+"', apellidoMaterno='"+usuario.getApellidoMaterno()+"', calle='"+usuario.getCalle()+"', numeroExterior="+usuario.getNumeroExterior()+", numeroInterior="+usuario.getNumeroInterior()+", colonia='"+usuario.getColonia()+"',municipio='"+usuario.getMunicipio()+"', codigoPostal="+usuario.getCodigoPostal()+",telefono='"+usuario.getTelefono()+"',tipoUsuario="+usuario.getTipoUsuario()+",password='"+usuario.getPassword()+"' WHERE usuarioId='"+usuario.getCodigoEmpleado()+"'");
	}

}
