package ayd.managment.store.modelo;

//Modelo para usuario
public class Usuario {
	//Atributos de ususario
	private String codigoEmpleado;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String calle;
	private int numeroExterior;
	private int numeroInterior;
	private String colonia;
	private String municipio;
	private int codigoPostal;
	private String telefono;
	private int tipoUsuario;//0 = empleado / 1 = encargado
	private String password;
	
	//Constructor
	public Usuario(String codigoEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, int numeroExterior, int numeroInterior, String colonia, String municipio, int codigoPostal, String telefono, int tipoUsuario, String password){
		super();
		this.codigoEmpleado = codigoEmpleado;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.calle = calle;
		this.numeroExterior = numeroExterior;
		this.numeroInterior = numeroInterior;
		this.colonia = colonia;
		this.municipio = municipio;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		this.password = password;
	}

	//Getters y Setters
	public String getCodigoEmpleado(){
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado){
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getApellidoPaterno(){
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno){
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno(){
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno){
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCalle(){
		return calle;
	}

	public void setCalle(String calle){
		this.calle = calle;
	}

	public int getNumeroExterior(){
		return numeroExterior;
	}

	public void setNumeroExterior(int numeroExterior){
		this.numeroExterior = numeroExterior;
	}

	public int getNumeroInterior(){
		return numeroInterior;
	}

	public void setNumeroInterior(int numeroInterior){
		this.numeroInterior = numeroInterior;
	}

	public String getColonia(){
		return colonia;
	}

	public void setColonia(String colonia){
		this.colonia = colonia;
	}

	public String getMunicipio(){
		return municipio;
	}

	public void setMunicipio(String municipio){
		this.municipio = municipio;
	}

	public int getCodigoPostal(){
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal){
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono(){
		return telefono;
	}

	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	public int getTipoUsuario(){
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
}

