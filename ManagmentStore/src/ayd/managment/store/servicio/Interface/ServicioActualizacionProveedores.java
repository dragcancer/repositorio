package ayd.managment.store.servicio.Interface;

import ayd.managment.store.modelo.Proveedor;

public interface ServicioActualizacionProveedores {
	public void inicia();
	public Proveedor regresaProveedor(String id);
	public boolean actualizaProveedor(Proveedor prov);
}
