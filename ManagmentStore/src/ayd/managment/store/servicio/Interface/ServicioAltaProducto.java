package ayd.managment.store.servicio.Interface;

import ayd.managment.store.persistencia.Intercafe.DAOProducto;

public interface ServicioAltaProducto {
		public void servicioAltaProducto(DAOProducto daoProducto);
		public void inicia();
		public boolean validarValores(String[] datos);
		public boolean darDeAltaProducto();
		public boolean codigoRepetido(String codigo);
}
