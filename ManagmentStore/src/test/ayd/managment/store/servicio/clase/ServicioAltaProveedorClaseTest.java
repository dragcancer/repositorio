package test.ayd.managment.store.servicio.clase;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.clase.ServicioAltaProveedorClase;

public class ServicioAltaProveedorClaseTest {
	ServicioAltaProveedorClase servicioAP;
	@Before
	public void setUp() throws Exception {
		servicioAP= new ServicioAltaProveedorClase();
	}
	@Test
	public void testAltaProveedor() {
		String nombre = "gomichela";
		String telefono = "5543981265";
		String tipo= "Bebiba";		
		Proveedor proveedor= new Proveedor(nombre,telefono,tipo);
		assertTrue(servicioAP.agregarProveedor(proveedor));
	}
}