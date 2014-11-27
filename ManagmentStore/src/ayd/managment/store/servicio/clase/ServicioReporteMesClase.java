package ayd.managment.store.servicio.clase;

import java.util.Date;

import ayd.managment.store.modelo.Venta;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;
import ayd.managment.store.persistencia.clase.DAOVentaClase;
import ayd.managment.store.servicio.Interface.ServicioReporteMes;
import ayd.managment.store.vista.VentanaReporteMes;

public class ServicioReporteMesClase implements ServicioReporteMes {
	
	VentanaReporteMes ventana = new VentanaReporteMes(this);

	@Override
	public void inicia() {
		ventana.setVisible(true);
	}
	
	public Venta[] generarReporte(String mes,String anio){
		DAOVenta daoventa= new DAOVentaClase();
		return daoventa.retriveVentasDelMes(generarFechaIni(mes,anio),generarFechaFin(mes,anio));
		
	}
	
	private String generarFechaIni(String mes,String anio){
		//funcion para obtener l fecha del sistema
		Date fecha = new Date();
		String Date;
		Date = String.format(anio+"-"+mes+"-"+"01"); 
		return Date;
	}
	
	private String generarFechaFin(String mes,String anio){
		//funcion para obtener l fecha del sistema
		Date fecha = new Date();
		String Date;
		int m=Integer.parseInt(mes);
		//1,3,5,7,8,10,12
		if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12 ){
			Date = String.format(anio+"-"+mes+"-"+"31"); 
		}else{
			if(m==4 || m==6 || m==9 || m==11){
				Date = String.format(anio+"-"+mes+"-"+"30"); 
			}else{
				Date = String.format(anio+"-"+mes+"-"+"28");
			}
		}
		return Date;
	}

}
