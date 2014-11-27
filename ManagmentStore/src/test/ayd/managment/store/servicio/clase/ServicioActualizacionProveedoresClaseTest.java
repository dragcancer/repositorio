package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.clase.ServicioActualizacionProveedoresClase;

public class ServicioActualizacionProveedoresClaseTest {
	ServicioActualizacionProveedoresClase servicioAPC;
	@Before
	public void setUp() throws Exception {
		servicioAPC= new ServicioActualizacionProveedoresClase();
	}
	
	@Test
	public void ActualizaProveedor() {
		String nombre = "gomichelas";
		String telefono = "5543981265";
		String tipo= "Bebiba";		
		Proveedor prov= new Proveedor(nombre,telefono,tipo);
		assertTrue(servicioAPC.actualizaProveedor(prov));
	}
}