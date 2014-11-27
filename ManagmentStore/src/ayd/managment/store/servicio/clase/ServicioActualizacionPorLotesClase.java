package ayd.managment.store.servicio.clase;

import java.util.ArrayList;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.servicio.Interface.ServicioActualizacionPorLotes;
import ayd.managment.store.vista.VentanaActualizacionPorLotes;

public class ServicioActualizacionPorLotesClase implements ServicioActualizacionPorLotes{

	//declaracion de atributos DAOProducto
	private DAOProducto daoProducto;
	
	//declaracion de atributos Producto[]
	private Producto[] productos;
	private Producto[] arregloProductos;
	
	//declaracion de atributos String[]
	private String[] proveedor;
	
	//declaracion de contructor y inicializacion DAOProducto
	public void servicioActualizacionPorLote(DAOProducto daoProducto){
		this.daoProducto = daoProducto;
	}
	
	//inicia ventanaActualizacionPorLotes
	public void inicia() {
		VentanaActualizacionPorLotes ventanaActualizacionPorLotes= new VentanaActualizacionPorLotes(this);
		ventanaActualizacionPorLotes.setVisible(true);
		
	}
	
	//regresa todos los proveedores sin repetir de la base de datos
	public String[]  listaProveedores(){
		productos = daoProducto.retriveAll();
		int i;
		ArrayList<String> proveedores= new ArrayList<String>();
		for(i=0;i<productos.length;i++){
			if(!proveedores.contains(productos[i].getProveedor())){
				proveedores.add(productos[i].getProveedor());
			}
		}
		proveedor = new String[proveedores.size()];
		proveedores.toArray(proveedor);
		return proveedor;
	}

	//cambia la existencia de los productos cambiados
	public boolean cambiaExistencia(float[] existencia){
		int indice;
		boolean valor;
		for(indice =0;indice<existencia.length;indice++){
			arregloProductos[indice].setExistenciaActual(existencia[indice]);
		}
		valor=daoProducto.updateProductos(arregloProductos);
		if(valor){
			return true;
		}else{
			return false;
		}
	}
	
	//regresa los productos de un proveedor
	public String[][] mostrarDatos(String proveedor){
		ArrayList<Producto> arrayListProducto= new ArrayList<Producto>();
		int indice1,indice2;
		for(indice1=0;indice1<productos.length;indice1++){
			if(productos[indice1].getProveedor().equals(proveedor)){
				arrayListProducto.add(productos[indice1]);
			}
		}
		arregloProductos= new Producto[arrayListProducto.size()];
		arrayListProducto.toArray(arregloProductos);
		 String[][] arregloProd = new String[arrayListProducto.size()][4];
		 indice1=0;
		 indice2=0;
		 for(Producto p: arrayListProducto){
			 arregloProd[indice1][indice2]=p.getCodigo();
			 indice2++;
			 arregloProd[indice1][indice2]=p.getNombre();
			 indice2++;
			 if(p.getTipo()==0){
				 arregloProd[indice1][indice2]=""+p.getExistenciaActual();
				 indice2++;
		 	 }else{
		 		arregloProd[indice1][indice2]=""+(int)p.getExistenciaActual();
				 indice2++;
		 	 }
			 arregloProd[indice1][indice2]=""+p.getTipo();
			 indice2++;
			 indice1++;
			 indice2=0;
		 }

		return arregloProd;
	
	}
	
}
