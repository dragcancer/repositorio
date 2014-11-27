package ayd.managment.store.modelo;

//Modelo para venta
public class Gasto {
	//Atributos para venta
	private String nombre;
	private String fecha;
	private String descripcion;
	private float abono;
	
	//Constructor
	public Gasto(String nombre, String fecha, String descripcion, float abono) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.abono = abono;
	}
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String idUsuario) {
		this.nombre = idUsuario;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getAbono() {
		return abono;
	}
	
	public void setAbono(float abono) {
		this.abono = abono;
	}
}
