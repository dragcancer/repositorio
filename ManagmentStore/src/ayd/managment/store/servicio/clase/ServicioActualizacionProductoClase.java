package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.servicio.Interface.ServicioActualizacionProducto;
import ayd.managment.store.vista.VentanaActualizacionProducto;

public class ServicioActualizacionProductoClase implements ServicioActualizacionProducto{
	//Variables de la clase
	private DAOProducto daoProducto;
	private VentanaActualizacionProducto ventana = new VentanaActualizacionProducto(this);
	private Producto producto;
	private boolean esNumero;
	
	//constructor con referencia a DAOProducto
	public void servicioActualizacionProducto(DAOProducto daoProducto){
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
	 * Recibe los nuevos datos para actualizar en un Arreglo de cadenas y realiza la validación de los datos recibidos, 
	 * esta es una validación que involucra a las Reglas de Negocio, 
	 * si la operación se realiza con éxito regresa un booleano = True, 
	 * en otro caso booleano = False.
	 */
	public boolean validarValores(String[] datos){
		producto.setCodigo(datos[0]);
		producto.setNombre(datos[1]);
		producto.setPrecioCompra(Float.parseFloat(datos[2]));
		producto.setPrecioMenudeo(Float.parseFloat(datos[3]));
		producto.setPrecioMayoreo(Float.parseFloat(datos[4]));
		producto.setCantidadMayoreo(Float.parseFloat(datos[5]));
		producto.setProveedor(datos[6]);
		producto.setExistenciaActual(Float.parseFloat(datos[7]));
		producto.setExistenciaMinima(Float.parseFloat(datos[8]));
		producto.setExistenciaMaxima(Float.parseFloat(datos[9]));
		producto.setTipo(Integer.parseInt(datos[10]));
		
		//Validacion de reglas de negocio
		if(producto.getExistenciaActual() <= 0 || producto.getExistenciaMinima() <= 0 || producto.getExistenciaMaxima() <= 0 || producto.getExistenciaMinima() >= producto.getExistenciaMaxima())
			return false;
		else
			if(producto.getPrecioCompra() <= 0 || producto.getPrecioMenudeo() <= 0 || producto.getPrecioMayoreo() <= 0)
				return false;
			else
				if(producto.getCantidadMayoreo() <=0)
					return false;
					else
						if(producto.getTipo()==1 && producto.getExistenciaActual()%1!=0 || producto.getTipo()==1 && producto.getCantidadMayoreo()%1!=0)
							return false;
						else
							return true;
	}
	
	/*
	 * Actualizar en un producto,
	 * si la operación se realiza con éxito regresa un booleano = True, en otro caso booleano = False.
	 */
	public boolean actualizarProducto(){
		if(producto.getCantidadMayoreo()==1)
			producto.setPrecioMayoreo(producto.getPrecioMenudeo());
		if(daoProducto.updateActualizacion(producto))
			return true;
		else
			return false;
	}
}
