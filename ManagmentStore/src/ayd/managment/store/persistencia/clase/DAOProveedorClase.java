package ayd.managment.store.persistencia.clase;


import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.persistencia.Intercafe.DAOProveedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOProveedorClase implements DAOProveedor {
	MyDataAcces mda;
	public DAOProveedorClase(MyDataAcces mda) {
		this.mda=mda;
	}
	public DAOProveedorClase() {
		
	}
	@Override
	public Proveedor retrive(String nombre) {
            
	    Proveedor proveedor = null;
		try {
			// Crea el statement
	
			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Proveedor WHERE Proveedor='"+nombre+"'");
			if(rs.next()){
				// Crea una nueva instancia del objeto
				proveedor = new Proveedor(rs.getString("proveedor"), rs.getString("telefono"), rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedor;
	}


	public boolean create(Proveedor proveedor){
			//Se crea el statement
			//Ejecuta sentencia para insertar un proveedor en la tabla	
            return mda.setQuery("insert into Proveedor values ('"+proveedor.getProveedor()+"','"+proveedor.getTelefono()+"','"+proveedor.getTipo()+"')");		
	}

	@Override
	public boolean delete(String proveedor) {
			// Crea el statement
			// Recibe los resutados
			return mda.setQuery("DELETE FROM Proveedor WHERE Proveedor='"+proveedor+"'");
	}
	
	public Proveedor[] retriveListado() {

		ArrayList <Proveedor> proveedoresTemp = new ArrayList <Proveedor>();
		try {
			// Crea el statement
			// Recibe los resutados
				ResultSet rs = mda.getQuery("SELECT * FROM Proveedor");

				while(rs.next()){
					// Crea una nueva instancia del objeto
					Proveedor proveedor = new Proveedor(rs.getString("proveedor"), rs.getString("telefono"), rs.getString("tipo"));
					proveedoresTemp.add(proveedor);
				}
				Proveedor proveedoresTempArreglo[]=new Proveedor[proveedoresTemp.size()];
				proveedoresTemp.toArray(proveedoresTempArreglo);
				return proveedoresTempArreglo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean update(Proveedor proveedor) {
			// Crea el statement
     		//Ejecuta sentencia para actualizar un producto en la tabla
			return mda.setQuery("update Proveedor set proveedor='"+proveedor.getProveedor()+"', telefono='"+proveedor.getTelefono()+"', tipo='"+proveedor.getTipo()+"' where proveedor='"+proveedor.getProveedor()+"'");
	}
        
}
