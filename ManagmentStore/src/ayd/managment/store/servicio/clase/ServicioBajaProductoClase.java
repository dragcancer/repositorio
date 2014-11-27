package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.servicio.Interface.ServicioBajaProducto;
import ayd.managment.store.vista.VentanaBajaProducto;

public class ServicioBajaProductoClase implements ServicioBajaProducto{
	
	private DAOProducto daoProducto;
	private VentanaBajaProducto ventana = new VentanaBajaProducto(this);
	private Producto producto;
	private boolean esNumero;
	
	//constructor con referencia a DAOProducto
	public void servicioBajaProducto(DAOProducto daoProducto){
		this.daoProducto = daoProducto;
	}
	
	//Inicia la ventana de actualizacion de productos
	public void inicia(){
	    ventana.setVisible(true);
	}
	
	/*
	 * Recibe un criterio de búsqueda (código o nombre) de un producto a actualizar,
	 * si la operación se realiza con éxito regresa un booleano = True, en otro caso booleano = False.
	 */
	public boolean buscarProducto(String criterio){
		if(daoProducto.cuantosProductos() == 0)
			return false;
		else{
			try{
				//aqui se decide si se hara retrive por codigo o nombre
				Integer.parseInt(criterio);	
				esNumero = true;
			}catch(NumberFormatException ex){
				esNumero = false;
			}
			if(esNumero)
				producto = daoProducto.retriveCodigo(criterio);
			else
				producto = daoProducto.retriveNombre(criterio);
			if(producto != null)
				return true;
			else
				return false;
		}
	}
	
	/*
	 * Regresa un arreglo de cadenas con los datos de un producto que se desea actualizar,
	 * para mostrarlos en la vista “Actualizar Producto”.
	 */
	public String[] mostrarDatos(){
		String datos[] = new String[11];
		datos[0] = producto.getCodigo();
		datos[1] = producto.getNombre();
		datos[2] = producto.getPrecioCompra()+"";
		datos[3] = producto.getPrecioMenudeo()+"";
		datos[4] = producto.getPrecioMayoreo()+"";
		datos[5] = producto.getCantidadMayoreo()+"";
		datos[6] = producto.getProveedor();
		datos[7] = producto.getExistenciaActual()+"";
		datos[8] = producto.getExistenciaMinima()+"";
		datos[9] = producto.getExistenciaMaxima()+"";
		datos[10] = producto.getTipo()+"";
		return datos;
	}
	
	/*
	 * Dar de Baja en un producto,
	 * si la operación se realiza con éxito regresa un booleano = True, en otro caso booleano = False.
	 */
	public boolean darDeBajaProducto(){
		if(daoProducto.delete(producto))
			return true;
		else
			return false;	
	}
}
