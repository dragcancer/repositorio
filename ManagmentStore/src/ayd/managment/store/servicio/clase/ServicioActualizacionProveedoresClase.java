package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.persistencia.Intercafe.DAOProveedor;
import ayd.managment.store.persistencia.clase.DAOProveedorClase;
import ayd.managment.store.persistencia.clase.MyDataAcces;
import ayd.managment.store.servicio.Interface.ServicioActualizacionProveedores;
import ayd.managment.store.vista.VentanaActualizacionProveedor;

public class ServicioActualizacionProveedoresClase implements ServicioActualizacionProveedores {
	
	VentanaActualizacionProveedor ventana = new VentanaActualizacionProveedor(this);
	DAOProveedor daoproveedor= new DAOProveedorClase();
	public void inicia() {
		// TODO Auto-generated method stub
		 ventana.setVisible(true);
	}
	public Proveedor regresaProveedor(String id){
		return daoproveedor.retrive(id);
	}

	public boolean actualizaProveedor(Proveedor prov){
		return daoproveedor.update(prov);
	}
}
