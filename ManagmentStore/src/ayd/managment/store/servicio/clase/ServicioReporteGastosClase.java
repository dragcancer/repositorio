package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Gasto;
import ayd.managment.store.persistencia.Intercafe.DAOGasto;
import ayd.managment.store.persistencia.clase.DAOGastoClase;
import ayd.managment.store.servicio.Interface.ServicioReporteGastos;
import ayd.managment.store.vista.VentanaReporteGastos;

public class ServicioReporteGastosClase implements ServicioReporteGastos{
	VentanaReporteGastos ventana= new VentanaReporteGastos(this);
	private DAOGasto rg;


	@Override
	public void inicia() {
		// TODO Auto-generated method stub
		ventana.setVisible(true);
	}
	
	public Gasto[] ConsultaGasto(String ini,String fin){
		rg=new DAOGastoClase();
		return rg.retriveGastosDelMes(ini, fin);
	}

}
