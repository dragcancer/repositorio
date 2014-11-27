package ayd.managment.store.modelo;

//Modelo para historial
public class Historial {
	//Atributos de Historial
	private String fecha;
	private int cantidad;
	private float total;
	
	//Constructor
	public Historial(String fecha, int cantidad, float total) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	//Getters y Setters
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
}

