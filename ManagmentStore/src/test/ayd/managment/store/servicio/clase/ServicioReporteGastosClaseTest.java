package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ayd.managment.store.servicio.clase.ServicioReporteGastosClase;

public class ServicioReporteGastosClaseTest {
	ServicioReporteGastosClase servicioRGC;
	@Before
	public void setUp() throws Exception {
		servicioRGC= new ServicioReporteGastosClase();
	}
	@Test
	public void testReporteGastos() {
		assertTrue(servicioRGC.ConsultaGasto("Noviembre", "2014")== null);
	}
}