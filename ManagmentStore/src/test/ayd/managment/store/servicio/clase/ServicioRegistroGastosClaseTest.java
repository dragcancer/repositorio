package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ayd.managment.store.servicio.clase.ServicioRegistroGastosClase;
import ayd.managment.store.modelo.Gasto;

public class ServicioRegistroGastosClaseTest {
	ServicioRegistroGastosClase servicioRGC;
	@Before
	public void setUp() throws Exception {
		servicioRGC= new ServicioRegistroGastosClase();
	}
	@Test
	public void testRegistroGastos() {
		String  nombre = "coca";
		String fecha = "Noviembre";
		String descripcion = "refresco";
		float abono = 11;
		 Gasto gasto = new Gasto(nombre,fecha,descripcion,abono);
		assertTrue(!servicioRGC.agregaGasto(gasto));
	}
}