package ayd.managment.store.persistencia.Intercafe;

import ayd.managment.store.modelo.Proveedor;



public interface DAOProveedor {
    boolean create(Proveedor proveedor);
	Proveedor retrive(String proveedor);
	boolean delete(String proveedor);
	public Proveedor[] retriveListado();
	public boolean update(Proveedor proveedor);
}
