package ayd.managment.store.persistencia.clase;
import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOProductoClase implements DAOProducto {
	MyDataAcces mda;
	public DAOProductoClase(MyDataAcces mda){
		this.mda= mda;
	}
	public DAOProductoClase(){
		
	}
	public boolean create(Producto producto) {
		return mda.setQuery("insert into Producto values ('"+producto.getCodigo()+"','"+producto.getNombre()+"',"+producto.getPrecioCompra()+","+producto.getPrecioMenudeo()+","+producto.getPrecioMayoreo()+","+producto.getCantidadMayoreo()+",'"+producto.getProveedor()+"',"+producto.getExistenciaActual()+","+producto.getExistenciaMinima()+","+producto.getExistenciaMaxima()+","+producto.getTipo()+")");		
	}
	
	//Retrive que regresa un codigo buscando por codigo
	public Producto retriveCodigo(String codigo) {
		Producto producto = null;
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Producto WHERE codigo='"+codigo+"'");

			if(rs.next())
				// Crea una nueva instancia del objeto
				producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precioCompra"), rs.getFloat("precioMenudeo"), rs.getFloat("precioMayoreo"), rs.getFloat("cantidadMayoreo"), rs.getString("proveedor"), rs.getFloat("existenciaActual"), rs.getFloat("existenciaMinima"), rs.getFloat("existenciaMaxima"), rs.getInt("tipo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}
	
	//Retrive que regresa un codigo buscando por nombre
	public Producto retriveNombre(String nombre) {
		Producto producto = null;

		try {
			// Crea el statement
			
			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Producto WHERE nombre='"+nombre+"'");

			if(rs.next())
				// Crea una nueva instancia del objeto
				producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precioCompra"), rs.getFloat("precioMenudeo"), rs.getFloat("precioMayoreo"), rs.getFloat("cantidadMayoreo"), rs.getString("proveedor"), rs.getFloat("existenciaActual"), rs.getFloat("existenciaMinima"), rs.getFloat("existenciaMaxima"), rs.getInt("tipo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}
	
	public Producto[] retriveNombreParcial(String nombre) {

		ArrayList <Producto> productosTemp = new ArrayList <Producto>();
		try {
			// Crea el statement
				if(nombre != null){
				// Recibe los resutados
				ResultSet rs = mda.getQuery("SELECT * FROM Producto");

				while(rs.next()){
					if(rs.getString("nombre").contains(nombre)){
					// Crea una nueva instancia del objeto
					Producto producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precioCompra"), rs.getFloat("precioMenudeo"), rs.getFloat("precioMayoreo"), rs.getFloat("cantidadMayoreo"), rs.getString("proveedor"), rs.getFloat("existenciaActual"), rs.getFloat("existenciaMinima"), rs.getFloat("existenciaMaxima"), rs.getInt("tipo"));
					productosTemp.add(producto);
					}
				}
				Producto productosTempArreglo[]=new Producto[productosTemp.size()];
				productosTemp.toArray(productosTempArreglo);
				return productosTempArreglo;
			}
			else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//update - actualiza los datos de un producto
	public boolean updateActualizacion(Producto producto){
		// Crea el statement
		//Ejecuta sentencia para actualizar un producto en la tabla
		return mda.setQuery("update Producto set "+"precioCompra="+producto.getPrecioCompra()+", precioMenudeo="+producto.getPrecioMenudeo()+", precioMayoreo="+producto.getPrecioMayoreo()+", cantidadMayoreo="+producto.getCantidadMayoreo()+", proveedor='"+producto.getProveedor()+"', existenciaActual="+producto.getExistenciaActual()+", existenciaMinima="+producto.getExistenciaMinima()+", existenciaMaxima="+producto.getExistenciaMaxima()+" where codigo='"+producto.getCodigo()+"'");
	}
	
	public boolean updateVenta(Producto producto){
		// Crea el statement
		//Ejecuta sentencia para actualizar un producto en la tabla
		return mda.setQuery("update Producto set "+"existenciaActual="+producto.getExistenciaActual()+" where codigo='"+producto.getCodigo()+"'");
	}
	
	public boolean delete(Producto producto) {
		// Recibe los resutados
		return mda.setQuery("DELETE FROM Producto WHERE codigo='"+producto.getCodigo()+"' AND nombre='"+producto.getNombre()+"'");

	}

	//Regresa la cantidad de productos guardados
	public int cuantosProductos() {
		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT COUNT(*) FROM Producto");
			if (rs.next()) 
		        return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
		
	// Regresa los proveedores en un arreglo
	public String[] proveedores(){
		/*ArrayList<String> proveedoresTemp = new ArrayList <String>();
		try {

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT DISTINCT proveedor FROM Producto");

			while(rs.next())
			{
				// Crea una nueva instancia del objeto
				String proveedor = new String(rs.getString("proveedor"));
				proveedoresTemp.add(proveedor);
			}
			
			String proveedoresTempArreglo[]=new String[proveedoresTemp.size()];
			proveedoresTemp.toArray(proveedoresTempArreglo);
			return proveedoresTempArreglo;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}*/
		return null;
	}
	
	// Da la lista de productos de el proveedor que se le pase como parametro
	public Producto[] buscaProductosProveedor(String proveedor) {

		ArrayList <Producto> productosTemp = new ArrayList <Producto>();

		try {
			// Crea el statement

			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Producto WHERE proveedor='"+proveedor+"'");

			while(rs.next())
			{
				// Crea una nueva instancia del objeto
				Producto producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precioCompra"), rs.getFloat("precioMenudeo"), rs.getFloat("precioMayoreo"), rs.getFloat("cantidadMayoreo"), rs.getString("proveedor"), rs.getFloat("existenciaActual"), rs.getFloat("existenciaMinima"), rs.getFloat("existenciaMaxima"), rs.getInt("tipo"));
				productosTemp.add(producto);
			}
			
			Producto productoTempArreglo[]=new Producto[productosTemp.size()];
			productosTemp.toArray(productoTempArreglo);
			return productoTempArreglo;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//regresa todos los productos la base de datos
	public Producto[] retriveAll() {
		Producto producto=null; 
		ArrayList <Producto> productosTemp = new ArrayList <Producto>();
		try {
			// Crea el statement
			// Recibe los resutados
			ResultSet rs = mda.getQuery("SELECT * FROM Producto");

			while(rs.next()){
				// Crea una nueva instancia del objeto
				producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precioCompra"), rs.getFloat("precioMenudeo"), rs.getFloat("precioMayoreo"), rs.getFloat("cantidadMayoreo"), rs.getString("proveedor"), rs.getFloat("existenciaActual"), rs.getFloat("existenciaMinima"), rs.getFloat("existenciaMaxima"), rs.getInt("tipo"));
				productosTemp.add(producto);
			}
			// se inicializa un objeto
			Producto productosTempArreglo[]=new Producto[productosTemp.size()];
			
			// se guardan los productos de en un objeto
			productosTemp.toArray(productosTempArreglo);
			return productosTempArreglo;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateProductos(Producto[] productos){
		int indice;
		// Crea el statement
		for(indice=0;indice<productos.length;indice++){
			//Ejecuta sentencia para actualizar un producto en la tabla
			mda.setQuery("update Producto set existenciaActual="+productos[indice].getExistenciaActual()+"WHERE codigo='"+productos[indice].getCodigo()+"'");
		}
		return true;
	}
}

