package ayd.managment.store.servicio.clase;

import java.util.ArrayList;

import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.persistencia.clase.DAOProductoClase;
import ayd.managment.store.modelo.Producto;
import ayd.managment.store.servicio.Interface.ServicioConsultaRapida;
import ayd.managment.store.vista.VentanaConsultaRapida;

public class ServicioConsultaRapidaClase implements ServicioConsultaRapida{
		
	private DAOProducto daoProducto;
	private VentanaConsultaRapida ventana = new VentanaConsultaRapida(this);
	private Producto producto;
	private Producto productos[];
	private boolean esNumero;
	private int indice;
	//Constructor con referencia a DAOProducto.
	public void servicioConsultaRapida(DAOProducto daoProducto){
		this.daoProducto = daoProducto;
	}
	//Inicia la ventana de Consulta Rapida.
	public void inicia(){
	    ventana.setVisible(true);
	}
	//Funcion que selecciona el metodo de busqueda dependiendo el tipo de argumento que recibe.
	public int buscarProducto(String criterio){
		if(daoProducto.cuantosProductos() == 0)
			return 0;
		else{
			try{
				Integer.parseInt(criterio);	
				esNumero = true;
			}catch(NumberFormatException ex){
				esNumero = false;
			}
			if(esNumero){
				if(buscarProductoCodigo(criterio))
					return 1;
				else
					return 0;
			}
			else{
				if(buscarProductoNombre(criterio))
					return 2;
				else
					return 0;
			}
		}
	}
	//Funcion que busca un producto bajo el criterio de Codigo del Producto
	public boolean buscarProductoCodigo(String codigo){
		if(daoProducto.cuantosProductos() == 0)
			return false;
		else{
			try{
				Integer.parseInt(codigo);	
				esNumero = true;
			}catch(NumberFormatException ex){
				esNumero = false;
			}
			if(esNumero)
				producto = daoProducto.retriveCodigo(codigo);
			if(producto != null)
				return true;
			else
				return false;
		}
	}
	//Funcion que busca un producto bajo el criterio de Nombre del Producto
	public boolean buscarProductoNombre(String nombre){
		if(daoProducto.cuantosProductos() == 0)
			return false;
		else{
			productos = daoProducto.retriveNombreParcial(nombre);
			if(productos.length != 0)
				return true;
			else
				return false;
		}
	}
	//Metodo que muestra nombre, precio menudeo, precio mayoreo, cantidad mayoreo y existencia en la tabla de un solo producto.
	public String[] mostrarDatos(){
		String datos[] = new String[5];
		datos[0] = producto.getNombre();
		datos[1] = producto.getPrecioMenudeo()+"";
		datos[2] = producto.getPrecioMayoreo()+"";
		datos[3] = producto.getCantidadMayoreo()+"";
		datos[4] = producto.getExistenciaActual()+"";
		return datos;
	}
	//Metodo que muestra nombre, precio menudeo, precio mayoreo, cantidad mayoreo y existencia en la tabla de un arreglo de productos.
	public ArrayList<String[]>  mostrarDatosLista(){
		ArrayList<String[]> datosProductos = new ArrayList<String[]>();
		for(indice = 0; indice < productos.length; indice++){
			String p[] = new String[5];
			p[0] = productos[indice].getNombre();
			p[1] = productos[indice].getPrecioMenudeo()+"";
			p[2] = productos[indice].getPrecioMayoreo()+"";
			p[3] = productos[indice].getCantidadMayoreo()+"";
			p[4] = productos[indice].getExistenciaActual()+"";
			datosProductos.add(p);
		}
		productos = null;
		return datosProductos;
	}
	public Producto[] getProductos(){
		daoProducto= new DAOProductoClase();
		return daoProducto.retriveAll();
	}
}
