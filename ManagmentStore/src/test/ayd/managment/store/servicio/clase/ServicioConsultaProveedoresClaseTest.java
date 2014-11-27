package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.clase.ServicioConsultaProveedoresClase;

public class ServicioConsultaProveedoresClaseTest {
	ServicioConsultaProveedoresClase servicioAPC;
	@Before
	public void setUp() throws Exception {
		servicioAPC= new ServicioConsultaProveedoresClase();
	}
	@Test
	public void testConsultaProveedor() {
		assertTrue(servicioAPC.despliegaProv() != null);
	}
}