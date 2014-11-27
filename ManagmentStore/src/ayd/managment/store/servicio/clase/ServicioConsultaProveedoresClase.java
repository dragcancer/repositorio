package ayd.managment.store.servicio.clase;

import java.util.ArrayList;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.persistencia.Intercafe.DAOProveedor;
import ayd.managment.store.persistencia.clase.DAOProveedorClase;
import ayd.managment.store.servicio.Interface.ServicioConsultaProveedores;
import ayd.managment.store.vista.VentanaConsultaProveedores;

public class ServicioConsultaProveedoresClase implements ServicioConsultaProveedores {
	
	private VentanaConsultaProveedores ventana = new VentanaConsultaProveedores(this);
	private DAOProveedor prov;
	private Proveedor [] arrProv;
	
	@Override
	public void inicia() {
		ventana.setVisible(true);
	}


	public Proveedor[] despliegaProv(){
		prov= new DAOProveedorClase();
		return prov.retriveListado();
	}


}//Fin de clase
