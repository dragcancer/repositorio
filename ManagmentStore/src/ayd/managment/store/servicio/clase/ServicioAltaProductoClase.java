package ayd.managment.store.servicio.clase;
import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.servicio.Interface.ServicioAltaProducto;
import ayd.managment.store.vista.VentanaAltaProducto;

public class ServicioAltaProductoClase implements ServicioAltaProducto{

	private DAOProducto daoProducto;
	private VentanaAltaProducto ventana = new VentanaAltaProducto(this);
	private Producto producto;
	
	//constructor con referencia a DAOProducto
	public void servicioAltaProducto(DAOProducto daoProducto){
		this.daoProducto = daoProducto;
	}
	
	//Inicia la ventana de actualizacion de productos
	public void inicia(){
	    ventana.setVisible(true);
	}
	
	// Valida valores de existencia, precio, cantidad
	public boolean validarValores(String[] datos){
		producto = new Producto(datos[0], datos[1], Float.parseFloat(datos[2]), Float.parseFloat(datos[3]), Float.parseFloat(datos[4]), Float.parseFloat(datos[5]), datos[6], Float.parseFloat(datos[7]), Float.parseFloat(datos[8]), Float.parseFloat(datos[9]), Integer.parseInt(datos[10]));
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
	

	// Metodo create para agregar un nuevo producto
	public boolean darDeAltaProducto(){
		if(producto.getCantidadMayoreo()==1)
			producto.setPrecioMayoreo(producto.getPrecioMenudeo());
			if(daoProducto.create(producto))
				return true;
			else
				return false;
	}
	
	// Metodo para verficar que no existan codigos repetidos. 
	public boolean codigoRepetido(String codigo){
		if(daoProducto.retriveCodigo(codigo)==null)
			return false;
		else
			return true;
	}
}
