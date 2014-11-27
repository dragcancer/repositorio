package ayd.managment.store.persistencia.clase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ayd.managment.store.modelo.Historial;
import ayd.managment.store.persistencia.Intercafe.DAOHistorial;

public class DAOHistorialClase implements DAOHistorial{
	MyDataAcces mda;
	public DAOHistorialClase(MyDataAcces mda){
		this.mda= mda;
	}
	public DAOHistorialClase(){

	}
	//Funcion que inserta una venta del dia en el historial, regresando true si hubo exito, y false si ocurrio un error.
	public boolean create(Historial historial) {
		//Se crea el statement
		//Ejecuta sentencia para insertar un producto en la tabla
		return mda.setQuery("insert into Historial values ('"+historial.getFecha()+"',"+historial.getCantidad()+","+historial.getTotal()+")");
	}
	//Funcion que regresa una venta de una fecha en especifico
	public Historial retriveHistorial(String fecha){
		Historial historial = null;
		try {
			// Crea el statement
			
			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Historial WHERE fecha='"+fecha+"'");

			if(rs.next())
				// Crea una nueva instancia del objeto
				historial = new Historial(rs.getString("fecha"), rs.getInt("cantidad"), rs.getFloat("total"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historial;
	}
	//Funcio que actualiza el historial de una venta regresando true si fue exitoso, false si hubo errores.
	public boolean updateHistorial(Historial historial){
		// Crea el statement
		//Ejecuta sentencia para actualizar un producto en la tabla
		return mda.setQuery("update Historial set "+"cantidad="+historial.getCantidad()+", total="+historial.getTotal()+" where fecha='"+historial.getFecha()+"'");
	}
	//Funcion que regresa el numero de historiales que hay en la base de datos
	public int cuantosHistoriales() {
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT COUNT(*) FROM Historial");
			if (rs.next()) 
		        return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

