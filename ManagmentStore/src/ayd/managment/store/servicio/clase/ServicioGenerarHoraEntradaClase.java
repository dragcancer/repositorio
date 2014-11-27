package ayd.managment.store.servicio.clase;

import java.util.Date;

import ayd.managment.store.modelo.DiaLaborado;
import ayd.managment.store.persistencia.Intercafe.DAODiaLaborado;
import ayd.managment.store.persistencia.Intercafe.DAOUsuario;
import ayd.managment.store.persistencia.clase.DAODiaLaboradoClase;
import ayd.managment.store.persistencia.clase.DAOUsuarioClase;
import ayd.managment.store.vista.VentanaHoraEntrada;

public class ServicioGenerarHoraEntradaClase {
	VentanaHoraEntrada ventana = new VentanaHoraEntrada(this);	
	DAODiaLaborado daoDiaLC;
	//DAODiaLaborado dUsuario;
	
	public boolean entradaHorario(String hora,String empleado){
		boolean val;
		DiaLaborado diaLaborado= new DiaLaborado(generarFecha(),hora,hora,empleado);
		daoDiaLC= new DAODiaLaboradoClase();
		DiaLaborado aux=daoDiaLC.buscaId(empleado,generarFecha());
		if(aux!=null){
			if(aux.getFecha().equals(diaLaborado.getFecha()) && aux.getCodigoEmpleado().equals(diaLaborado.getCodigoEmpleado())){
				return false;
			}else{
				return daoDiaLC.agregaDiaLaborado(diaLaborado);
			}
		}else{
			return false;
		}
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
