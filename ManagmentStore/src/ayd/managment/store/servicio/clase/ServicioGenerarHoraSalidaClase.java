package ayd.managment.store.servicio.clase;

import java.util.Date;

import ayd.managment.store.modelo.DiaLaborado;
import ayd.managment.store.persistencia.clase.DAODiaLaboradoClase;
import ayd.managment.store.vista.VentanaHoraEntrada;
import ayd.managment.store.vista.VentanaHoraSalida;

public class ServicioGenerarHoraSalidaClase {
	VentanaHoraSalida ventana = new VentanaHoraSalida(this);
	DAODiaLaboradoClase daoDiaLC;
	public ServicioGenerarHoraSalidaClase() {
	
	}
	
	public boolean salidaHorario(String hora,String empleado){
		daoDiaLC= new DAODiaLaboradoClase();
		boolean x=false;
		DiaLaborado salida= daoDiaLC.buscaId(empleado,generarFecha());
		if (salida!=null){
			if(salida.getCodigoEmpleado().equals(empleado)){
				x =daoDiaLC.actualizaHoraSalida(salida.getCodigoEmpleado(),salida.getFecha(), hora);
				return x;
			}
		}else{
			return x;
		}
	    return x;
	}
	
	private String generarFecha(){
		//funcion para obtener l fecha del sistema
		Date fecha = new Date();
		String Date;
		Date = String.format("%04d-%02d-%02d",fecha.getYear()+1900,fecha.getMonth()+1,fecha.getDate()); 
		return Date;
	}
	
	public void inicia(){
	    ventana.setVisible(true);
	}

}
