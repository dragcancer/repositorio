package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;
import ayd.managment.store.servicio.clase.ServicioGenerarHoraSalidaClase;

public class ServicioGenerarHoraSalidaClaseTest {
	ServicioGenerarHoraSalidaClase servicioHE;
	@Before
	public void setUp() throws Exception {
		servicioHE=new ServicioGenerarHoraSalidaClase();
	}

	@Test
	public void testSalidaHorario() {
		assertTrue(servicioHE.salidaHorario("08:40:00", "mpm993"));
	}

}
