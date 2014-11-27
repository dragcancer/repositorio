package ayd.managment.store.modelo;

//Modelo para venta
public class Venta {
	//Atributos para venta
	private String fecha;
	private String hora;
	private float ganancia;
	
	//Constructor
	public Venta(String fecha, String hora, float ganancia) {
		this.fecha = fecha;
		this.hora = hora;
		this.ganancia = ganancia;
	}
	//Getters y Setters
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public float getGanancia() {
		return ganancia;
	}

	public void setGanancia(float ganancia) {
		this.ganancia = ganancia;
	}
}
