package test.ayd.managment.store.servicio.clase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.modelo.Venta;
import ayd.managment.store.persistencia.clase.DAOProductoClase;
import ayd.managment.store.persistencia.clase.DAOVentaClase;
import ayd.managment.store.servicio.clase.ServicioVentasClase;

public class ServicioVentasClaseTest {

	ServicioVentasClase servicio = new ServicioVentasClase();
	@Test
	public void testGuardarVentaPDF() {
		//Guarda la venta en el formato de pdf, y espera un true
		assertTrue(servicio.guardarVentaPDF() == true);
	}
}
