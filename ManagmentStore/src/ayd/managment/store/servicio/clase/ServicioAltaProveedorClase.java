package ayd.managment.store.servicio.clase;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.persistencia.Intercafe.DAOProveedor;
import ayd.managment.store.persistencia.clase.DAOProveedorClase;
import ayd.managment.store.servicio.Interface.ServicioAltaProveedor;
import ayd.managment.store.vista.VentanaAltaProveedor;

public class ServicioAltaProveedorClase implements ServicioAltaProveedor {
	private VentanaAltaProveedor ventana = new VentanaAltaProveedor(this);
	DAOProveedor daoproveedor; 
	@Override
	public void inicia() {
	    ventana.setVisible(true);		
	}
	
	private boolean buscaProveedor(String nombre){
		daoproveedor = new DAOProveedorClase();	
		if(daoproveedor.retrive(nombre) == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean agregarProveedor(Proveedor proveedor) {
		System.out.println("entreee");
		if(!buscaProveedor(proveedor.getProveedor())){
				return false;
			}
			else{
				//Proveedor prov = new Proveedor(nombre, telefono, tipo);
				if(daoproveedor.create(proveedor)){
					return true;
				}
				else{
					return false;
				}
			}		
	}

}
