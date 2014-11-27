package ayd.managment.store.modelo;

//Modelo para producto
public class Producto {
	//Atributos de producto
	private String codigo;
	private String nombre;
	private float precioCompra;
	private float precioMenudeo;
	private float precioMayoreo;
	private float cantidadMayoreo;
	private String proveedor;
	private float existenciaActual;
	private float existenciaMinima;
	private float existenciaMaxima;
	private int tipo;//0 = a granel // 1 = pieza
	
	//Constructor
	public Producto(String codigo, String nombre, float precioCompra, float precioMenudeo, float precioMayoreo, float cantidadMayoreo, String proveedor, float existenciaActual, float existenciaMinima, float existenciaMaxima, int tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioMenudeo = precioMenudeo;
		this.precioMayoreo = precioMayoreo;
		this.cantidadMayoreo = cantidadMayoreo;
		this.proveedor = proveedor;
		this.existenciaActual = existenciaActual;
		this.existenciaMinima = existenciaMinima;
		this.existenciaMaxima = existenciaMaxima;
		this.tipo = tipo;
	}
	
	//Getters y Setters
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPrecioCompra() {
		return precioCompra;
	}
	
	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	public float getPrecioMenudeo() {
		return precioMenudeo;
	}
	
	public void setPrecioMenudeo(float precioMenudeo) {
		this.precioMenudeo = precioMenudeo;
	}
	
	public float getPrecioMayoreo() {
		return precioMayoreo;
	}
	
	public void setPrecioMayoreo(float precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}
	
	public float getCantidadMayoreo() {
		return cantidadMayoreo;
	}
	
	public void setCantidadMayoreo(float cantidadMayoreo) {
		this.cantidadMayoreo = cantidadMayoreo;
	}
	
	public String getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	public float getExistenciaActual() {
		return existenciaActual;
	}
	
	public void setExistenciaActual(float existenciaActual) {
		this.existenciaActual = existenciaActual;
	}
	
	public float getExistenciaMinima() {
		return existenciaMinima;
	}
	
	public void setExistenciaMinima(float existenciaMinima) {
		this.existenciaMinima = existenciaMinima;
	}
	
	public float getExistenciaMaxima() {
		return existenciaMaxima;
	}
	
	public void setExistenciaMaxima(float existenciaMaxima) {
		this.existenciaMaxima = existenciaMaxima;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
