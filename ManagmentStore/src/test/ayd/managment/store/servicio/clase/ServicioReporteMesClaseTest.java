package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ayd.managment.store.servicio.clase.ServicioReporteMesClase;

public class ServicioReporteMesClaseTest {

	ServicioReporteMesClase sreporte;
	@Before
	public void setUp() throws Exception {
		sreporte= new ServicioReporteMesClase();
		
	}

	@Test
	public void testGenerarReporte() {
		assertTrue(sreporte.generarReporte("04", "2015")!=null);
	}

}
