package ayd.managment.store.servicio.clase;

import java.util.ArrayList;
import java.util.Date;

import ayd.managment.store.servicio.Interface.ServicioGenerarHoras;
import ayd.managment.store.vista.VentanaGenerarHoras;
import ayd.managment.store.modelo.DiaLaborado;
import ayd.managment.store.persistencia.Intercafe.DAODiaLaborado;

public class ServicioGenerarHorasClase implements ServicioGenerarHoras{
	private DAODiaLaborado daoDiaLaborado;
	VentanaGenerarHoras ventana = new VentanaGenerarHoras(this);
	DiaLaborado diaLaborado= null;
	private DiaLaborado[] diasLaborados;
	
	public void servicioGenerarHorasClase(DAODiaLaborado daoDiaLaborado) {
		this.daoDiaLaborado = daoDiaLaborado;
	}
	
	
	public boolean buscarUsuario(String codigoEmpleado){
		//con esta funcion hago la validacion si es que el usuario esta en la tabla
		boolean res=false;
		if(daoDiaLaborado.buscaUsuario(codigoEmpleado)!=null){
			res=true;
		}
		return res;
	}
	
	public boolean buscarDiasLaborados(String idUsuario, String fechaLimite){
		//obtengo la tabla de dia laborado y regreso un true
		boolean res=false;
		int Dias=Integer.parseInt(fechaLimite);
		if(daoDiaLaborado.dameDiasLaborados(idUsuario, generarFecha(), generarFechaLimite(Dias)) != null){
			res=true;
		}
		return res;
	}
	
	public float calculaSalario(String pagoPorHoras){
		//separo el tiempo por medio de el caracter : y despues convierto a horas y lo multiplico por un pago para obtener el total
		float sueldo,total=0,horaE,minutoE,horaS,minutoS,HorasEAux,HorasSAux,HorasTotales=0;
		sueldo=Float.parseFloat(pagoPorHoras);
		for(int i = 0; i < diasLaborados.length; i++){
			String[] enterosEntrada = new String[3];
			String[] enterosSalida = new String[3];
			enterosEntrada = diasLaborados[i].getHoraEntrada().split(":");
			enterosSalida = diasLaborados[i].getHoraSalida().split(":");
			horaE = Float.parseFloat(enterosEntrada[0]);
			minutoE = Float.parseFloat(enterosEntrada[1]);
			horaS = Float.parseFloat(enterosSalida[0]);
			minutoS = Float.parseFloat(enterosSalida[1]);
			//convertimos el tiempo a horas 
			HorasEAux=minutoE/60;
			HorasSAux=minutoS/60;
			HorasTotales = HorasTotales+((horaS+HorasSAux)-(horaE+HorasEAux));	
		}
		total = total+HorasTotales*sueldo;
		if(HorasTotales>50)
			total = total*(float)1.05;
		total = (float)Math.rint(total*100)/100;
		return total;
	}
	
	public ArrayList<String[]> muestraDiasLaborados(String idUsuario, String fechaLimite){

		ArrayList<String[]> arregloDias = new ArrayList<String[]>();
		
		int Dias=Integer.parseInt(fechaLimite);
		//paso el arreglo que consigo del dao a otro arreglo para mostrarlo
		diasLaborados=daoDiaLaborado.dameDiasLaborados(idUsuario, generarFecha(), generarFechaLimite(Dias));
		for(int i = 0; i < diasLaborados.length ; i++){
			String[] datos = new String[3];
			datos[0] = diasLaborados[i].getFecha();
			datos[1] = diasLaborados[i].getHoraEntrada();
			datos[2] = diasLaborados[i].getHoraSalida();
			arregloDias.add(datos);
		}
		return arregloDias;
	}
	
	@SuppressWarnings("deprecation")
	public String generarFecha(){
		//funcion para obtener l fecha del sistema
		Date fecha = new Date();
		String Date;
		Date = String.format("%04d-%02d-%02d",fecha.getYear()+1900,fecha.getMonth()+1,fecha.getDate()); 
		 
		return Date;
	}	
	
	@SuppressWarnings("deprecation")
	public String generarFechaLimite(int Limite){
		//obtengo las fecha del sistema menos los dias que el usuario indique
		Date fecha = new Date();
		String Date;
		Date = String.format("%04d-%02d-%02d",fecha.getYear()+1900,fecha.getMonth()+1,fecha.getDate()-Limite); 
		 
		return Date;
	}	
	
	public void inicia(){
	    ventana.setVisible(true);
	}
}