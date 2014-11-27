package ayd.managment.store.modelo;

public class Proveedor {
	private String proveedor;
	private String telefono;
	private String tipo;
	public Proveedor(String nombre, String telefono, String tipo) {
		this.setProveedor(nombre);
			this.setTelefono(telefono);
			this.setTipo(tipo);
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
