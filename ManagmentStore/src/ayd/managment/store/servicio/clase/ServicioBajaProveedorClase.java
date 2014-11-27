package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.persistencia.Intercafe.DAOProveedor;
import ayd.managment.store.persistencia.clase.DAOProveedorClase;
import ayd.managment.store.servicio.Interface.ServicioBajaProveedor;
import ayd.managment.store.vista.VentanaBajaProveedor;

public class ServicioBajaProveedorClase implements ServicioBajaProveedor {
	
	private VentanaBajaProveedor ventana = new VentanaBajaProveedor(this);

	@Override
	public void inicia() {
		ventana.setVisible(true);
		
	}
	public Proveedor verificaProveedor(String nombre){
		DAOProveedor d= new DAOProveedorClase();
		return d.retrive(nombre);
	}
	public boolean BajaProveedor(String nombre){
		DAOProveedor d= new DAOProveedorClase();
		if(d.delete(nombre)){
			return true;
		}else{
			return false;
		}
	}

}
