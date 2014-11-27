package ayd.managment.store.persistencia.clase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ayd.managment.store.modelo.Venta;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;

public class DAOVentaClase implements DAOVenta{
	MyDataAcces mda;
	public DAOVentaClase(MyDataAcces mda){
		this.mda=mda;
	}
	public DAOVentaClase(){

	}
	//Funcion que crea una nueva venta en la base de datos.
	public boolean create(Venta venta) {

			//Se crea el statement
		//Ejecuta sentencia para insertar un producto en la tabla
			//statement.execute("insert into Venta values (DEFAULT,'2014-06-29','20:40:29',100)");
			return mda.setQuery("insert into Venta values (DEFAULT,'"+venta.getFecha()+"','"+venta.getHora()+"',"+venta.getGanancia()+")");		

	}
	//Funcion que regresa un arreglo de ventas que concuerdan con una fecha especifica.
	public Venta[] retriveVentasDelDia(String fecha) {

		ArrayList <Venta> ventasTemp = new ArrayList <Venta>();
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Venta WHERE fecha='"+fecha+"'");

			while(rs.next()){
				//if(rs.getString("nombre").contains(fecha)){
				// Crea una nueva instancia del objeto
				Venta venta = new Venta(rs.getString("fecha"), rs.getString("hora"), rs.getFloat("ganancia"));
				ventasTemp.add(venta);
				//}
			}
			Venta ventasTempArreglo[]=new Venta[ventasTemp.size()];
			ventasTemp.toArray(ventasTempArreglo);
			return ventasTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//Funcion que regresa el numero de ventas en la base de datos.
	public int cuantasVentas() {
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT COUNT(*) FROM Venta");
			if (rs.next()) 
		        return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Venta[] retriveVentasDelMes(String fechaIni,String fechaFin) {

		ArrayList <Venta> ventasTemp = new ArrayList <Venta>();
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Venta WHERE fecha >='"+fechaIni+"' AND fecha < '"+fechaFin+"'");

			while(rs.next()){
				//if(rs.getString("nombre").contains(fecha)){
				// Crea una nueva instancia del objeto
				Venta venta = new Venta(rs.getString("fecha"), rs.getString("hora"), rs.getFloat("ganancia"));
				ventasTemp.add(venta);
				//}
			}
			Venta ventasTempArreglo[]=new Venta[ventasTemp.size()];
			ventasTemp.toArray(ventasTempArreglo);
			return ventasTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
