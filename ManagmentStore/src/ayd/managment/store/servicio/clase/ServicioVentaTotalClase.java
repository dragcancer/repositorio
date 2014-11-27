package ayd.managment.store.servicio.clase;

import java.util.ArrayList;
import java.util.Date;

import ayd.managment.store.modelo.Historial;
import ayd.managment.store.modelo.Venta;
import ayd.managment.store.persistencia.Intercafe.DAOHistorial;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;
import ayd.managment.store.servicio.Interface.ServicioVentaTotal;
import ayd.managment.store.vista.VentanaVentaTotal;

public class ServicioVentaTotalClase implements ServicioVentaTotal{
	//variables de clase
	private DAOVenta daoVenta;
	private DAOHistorial daoHistorial;
	private VentanaVentaTotal ventana = new VentanaVentaTotal(this);
	private Venta[] ventas;
	private Historial historial;
	private Date fechaSistema;
	private int indice;
	private int cantidad;
	private float total;
	
	//recibe el daoventa y daohistorial
	public void servicioVentaTotal(DAOVenta daoVenta, DAOHistorial daoHistorial){
		this.daoVenta = daoVenta;
		this.daoHistorial = daoHistorial;
	}
	
	//muestra la ventana
	public void inicia(){
	    ventana.setVisible(true);
	}
	
	//busca si hay ventas realizadas en la fecha indicada
	//si el resultado es cero regresa un booleando = false
	// si son mayores a cero regresa un booleano = true
	public boolean buscarVentas(){
		if(daoVenta.cuantasVentas() == 0)
			return false;
		else{
			ventas = daoVenta.retriveVentasDelDia(generarFecha());
			if(ventas.length != 0)
				return true;
			else
				return false;
		}
	}
	
	//regresa un arreglo de ventas realizadas
	public ArrayList<String[]>  mostrarDatosLista(){
		ArrayList<String[]> datosVentas = new ArrayList<String[]>();
		for(indice = 0; indice < ventas.length; indice++){
			String p[] = new String[3];
			p[0] = ventas[indice].getFecha();
			p[1] = ventas[indice].getHora();
			p[2] = ventas[indice].getGanancia()+"";
			datosVentas.add(p);
		}
		ventas = null;
		return datosVentas;
	}
	
	//calcula el total por totas las ventas realizadas en el dia
	public boolean calcularVentas(ArrayList<String> ventas){
		float t;
		boolean band = false;
		cantidad = 0;
		total = 0;
		
		for(indice = 0; indice < ventas.size(); indice++){
			try{
				t = Float.parseFloat(ventas.get(indice));
				cantidad++;
				total = total + t;
				band = true;	
			}catch(NumberFormatException ex){
				band = false;
				break;
			}
		}
		if(band)
			return true;
		else 
			return false;
	}
	
	//regresa el total de las ventas
	public float muestraTotal(){
		return total;
	}
	
	//guarda en historial el total de las ventas de un dia
	//anexa la fecha del dia en que se realziaron todas las ventas correspondientes
	public boolean guardaEnHistorial(){
		Historial historialbusca;
		historial = new Historial(generarFecha(),cantidad,total);
		historialbusca = daoHistorial.retriveHistorial(generarFecha());
		if(historialbusca != null){
			if(historialbusca.getTotal()<historial.getTotal()){
				if(daoHistorial.updateHistorial(historial))
					return true;
				else
					return false;
			}
			else{
				return false;
			}
		}
		else{
			if(daoHistorial.create(historial)){
				historial = null;
				return true;
			}
			else
				return false;
		}
	}
	
	//toma la fecha del sistema
	@SuppressWarnings("deprecation")
	private String generarFecha(){
		fechaSistema = new Date();
		String fecha;
		fecha = String.format("%04d-%02d-%02d",fechaSistema.getYear()+1900,fechaSistema.getMonth()+1,fechaSistema.getDate()); 
		return fecha;
	}	
}
