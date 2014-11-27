package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import ayd.managment.store.servicio.clase.ServicioBajaProveedorClase;

public class ServicioBajaProveedorClaseTest {
	ServicioBajaProveedorClase servicioBP;
	@Before
	public void setUp() throws Exception {
		servicioBP= new ServicioBajaProveedorClase();
	}
	@Test
	public void testBajaProveedor() {
		 String nombre = "gomichela";
		assertTrue(servicioBP.BajaProveedor(nombre));
	}
}
