package ayd.managment.store.servicio.Interface;

public interface ServicioActualizacionPorLotes {
	public void inicia();
	public String[]  listaProveedores();
	public boolean cambiaExistencia(float[] existencia);
	public String[][] mostrarDatos(String proveedor);
}
