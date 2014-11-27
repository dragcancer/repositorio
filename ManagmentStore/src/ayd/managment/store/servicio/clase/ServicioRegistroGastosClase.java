package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Gasto;
import ayd.managment.store.persistencia.Intercafe.DAOGasto;
import ayd.managment.store.persistencia.clase.DAOGastoClase;
import ayd.managment.store.vista.VentanaRegistroGastos;
import ayd.managment.store.servicio.Interface.ServicioRegistroGastos;

public class ServicioRegistroGastosClase implements ServicioRegistroGastos{
	//Variables de clase
	private VentanaRegistroGastos ventana = new VentanaRegistroGastos(this);
	private DAOGasto daoGasto;
	private Gasto gasto;
	
	//Recibe el daoGasto
	/*public void servicioRegistroGasto(DAOGasto daoGasto){
		this.daoGasto = daoGasto;
	}*/
	
	public void inicia() {
	    ventana.setVisible(true);		
	}
	
	public boolean agregaGasto(Gasto gasto) {
			daoGasto= new DAOGastoClase();
			if(daoGasto.create(gasto))
				return true;
			else
				return false;
	}
	
}
