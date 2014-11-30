package ayd.managment.store.modelo;

//Modelo
public class DiaLaborado {
	//Atributos de diaLaborado
	private String fecha;
	private String horaEntrada;
	private String horaSalida;
	private String codigoEmpleado;
	
	//Constructor
	public DiaLaborado(String fecha, String horaEntrada, String horaSalida,String codigoEmpleado ){
		this.fecha=fecha;
		this.horaEntrada=horaEntrada;
		this.horaSalida=horaSalida;
		this.codigoEmpleado=codigoEmpleado;
	}
	
	//Getters y Setters
	public String getFecha(){
		return fecha;
	}
	
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	
	public String getHoraEntrada(){
		return horaEntrada;
	}
	
	public String getHoraSalida(){
		return horaSalida;
	}
	public String getCodigoEmpleado(){
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado){
		this.codigoEmpleado = codigoEmpleado;
	}
}
