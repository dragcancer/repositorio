package ayd.managment.store.persistencia.clase;

import java.util.ArrayList;

import ayd.managment.store.modelo.DiaLaborado;
import ayd.managment.store.persistencia.Intercafe.DAODiaLaborado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAODiaLaboradoClase implements DAODiaLaborado{
	MyDataAcces mda;

	public DAODiaLaboradoClase(MyDataAcces mda){
		this.mda= mda;
	}
	
	public DAODiaLaboradoClase(){

	}
	//Funcion que agrega un Dia Laborado a la base de datos y regresa true si fue exitoso y false si hubi un error.
	public boolean agregaDiaLaborado(DiaLaborado diaLaborado) {
		return mda.setQuery("insert into DiaLaborado values (DEFAULT,'"+diaLaborado.getFecha()+"','"+diaLaborado.getHoraEntrada()+"','"+diaLaborado.getHoraEntrada()+"','"+diaLaborado.getCodigoEmpleado()+"')");
	}
	
	//Funcion que genera un arreglo de los dias laborados por un empleado en un periodo de tiempo.
	public DiaLaborado[] dameDiasLaborados(String idUsuario, String fecha, String fechaLimite) {

		ArrayList <DiaLaborado> dialaboradoTemp = new ArrayList <DiaLaborado>();

		try {
			// Crea el statement
	//		Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM DiaLaborado WHERE usuarioId='"+idUsuario+"' AND (fecha BETWEEN '"+fechaLimite+"' AND '"+fecha+"')");
			while(rs.next())
			{
				// Crea una nueva instancia del objeto
				DiaLaborado dialaborado = new DiaLaborado(rs.getString("fecha"), rs.getString("HoraEntrada"), rs.getString("HoraSalida"), rs.getString("usuarioId"));
				dialaboradoTemp.add(dialaborado);
			}

			DiaLaborado DiaTempArreglo[]=new DiaLaborado[dialaboradoTemp.size()];
			dialaboradoTemp.toArray(DiaTempArreglo);
			return DiaTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//Funcion que busca si un empleado a trabajado.
	public DiaLaborado buscaUsuario(String id) {
		//Busco el usuario en la tabla dia laborado
		DiaLaborado dialaborado = null;

		try {
			// Crea el statement

			// Recibe los resutados
			
			ResultSet rs = mda.getQuery("SELECT * FROM DiaLaborado WHERE usuarioId='"+id+"'");
			

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				dialaborado = new DiaLaborado(rs.getString("fecha"), rs.getString("HoraEntrada"),rs.getString("HoraSalida"),rs.getString("usuarioId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dialaborado;
	}

	
	public DiaLaborado buscaId(String id,String fecha) {
		//Busco el usuario en la tabla dia laborado
		DiaLaborado dialaborado = null;

		try {
			// Crea el statement

			// Recibe los resutados                                                      
			ResultSet rs = mda.getQuery("SELECT * FROM DiaLaborado WHERE fecha='"+fecha+"' AND usuarioId='"+id+"'");
			
			if(rs.next())
			{
				// Crea una nueva instancia del objeto
		
				dialaborado = new DiaLaborado(rs.getString("fecha"), rs.getString("HoraEntrada"),rs.getString("HoraSalida"),rs.getString("usuarioId"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dialaborado;
	}
	
	public boolean actualizaHoraSalida(String id,String fecha,String horasal){
		// Crea el statement
		// actualiza los del usuario
		return mda.setQuery("UPDATE DiaLaborado SET HoraSalida='"+horasal+"' WHERE fecha='"+fecha+"' AND usuarioId='"+id+"' ");

	}
}

