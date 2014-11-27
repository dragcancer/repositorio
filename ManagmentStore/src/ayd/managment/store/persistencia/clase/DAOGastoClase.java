package ayd.managment.store.persistencia.clase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ayd.managment.store.modelo.Gasto;
import ayd.managment.store.persistencia.Intercafe.DAOGasto;

public class DAOGastoClase implements DAOGasto{
	MyDataAcces mda;

	public DAOGastoClase(MyDataAcces mda){
		this.mda=mda;
	}
	
	public DAOGastoClase(){
		mda= new MyDataAcces();
	}
	//Funcion que crea una nueva Gasto en la base de datos.
	public boolean create(Gasto gasto) {
		return mda.setQuery("insert into Gasto (usuarioId,nombre,fecha,descripcion,abono) values ('cvc476','"+gasto.getNombre()+"','"+gasto.getFecha()+"','"+gasto.getDescripcion()+"',"+gasto.getAbono()+")");
	}
	//Funcion que regresa un arreglo de Gastos que concuerdan con una fecha especifica.
	public Gasto[] retriveGastos() {

		ArrayList <Gasto> GastosTemp = new ArrayList <Gasto>();
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Gasto");

			while(rs.next()){
				//if(rs.getString("nombre").contains(fecha)){
				// Crea una nueva instancia del objeto
				
				Gasto gasto = new Gasto(rs.getString("gasto"), rs.getString("fecha"), rs.getString("descripcion"), rs.getFloat("abono"));
				GastosTemp.add(gasto);
				//}
			}
			Gasto GastosTempArreglo[]=new Gasto[GastosTemp.size()];
			GastosTemp.toArray(GastosTempArreglo);
			return GastosTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//Funcion que regresa el numero de Gastos en la base de datos.
	public int cuantosGastos() {
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT COUNT(*) FROM Gasto");
			if (rs.next()) 
		        return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Gasto[] retriveGastosDelMes(String fechaIni,String fechaFin) {

		ArrayList <Gasto> GastosTemp = new ArrayList <Gasto>();
		try {
			// Crea el statement
			
			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Gasto WHERE fecha >='"+fechaIni+"' AND fecha < '"+fechaFin+"'");

			while(rs.next()){
				//if(rs.getString("nombre").contains(fecha)){
				// Crea una nueva instancia del objeto
				
				Gasto gasto = new Gasto(rs.getString("gasto"), rs.getString("fecha"), rs.getString("descripcion"), rs.getFloat("abono"));
				GastosTemp.add(gasto);
				//}
			}
			Gasto GastosTempArreglo[]=new Gasto[GastosTemp.size()];
			GastosTemp.toArray(GastosTempArreglo);
			return GastosTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
