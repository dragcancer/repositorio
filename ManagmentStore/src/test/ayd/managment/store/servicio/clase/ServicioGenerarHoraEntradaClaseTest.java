package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;

public class ServicioGenerarHoraEntradaClaseTest {

	ServicioGenerarHoraEntradaClase servicioHE;
	@Before
	public void setUp() throws Exception {
		servicioHE= new ServicioGenerarHoraEntradaClase();
	}
	@Test
	public void testEntradaHorario() {
		assertTrue(servicioHE.entradaHorario("08:40:00", "mpm993"));
	}

}
