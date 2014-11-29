package ayd.managment.store.principal;
import ayd.managment.store.persistencia.clase.*;
import ayd.managment.store.persistencia.clase.MyDataAcces;
import ayd.managment.store.servicio.clase.*;
import ayd.managment.store.vista.*;

public class Aplicacion {	
	//Variables de clase
	//DAOs
	//Bad word 123456
	MyDataAcces mda= new MyDataAcces();
	private DAOProductoClase daoProducto = new DAOProductoClase(mda);
	private DAOUsuarioClase daoUsuario = new DAOUsuarioClase(mda);
	private DAOVentaClase daoVenta = new DAOVentaClase(mda);
	private DAOHistorialClase daoHistorial = new DAOHistorialClase(mda);
	private DAODiaLaboradoClase daoDiaLaborado = new DAODiaLaboradoClase(mda);
	
	//Servicios
	private ServicioLoginClase servicioLogin = new ServicioLoginClase();
	private ServicioAltaProductoClase servicioAltaProducto = new ServicioAltaProductoClase();
	private ServicioBajaProductoClase servicioBajaProducto = new ServicioBajaProductoClase();
	private ServicioActualizacionProductoClase servicioActualizacionProducto = new ServicioActualizacionProductoClase();
	private ServicioActualizacionPorLotesClase servicioActualizacionPorLotes = new ServicioActualizacionPorLotesClase();
	private ServicioAltaUsuarioClase servicioAltaUsuario = new ServicioAltaUsuarioClase();
	private ServicioBajaUsuarioClase servicioBajaUsuario = new ServicioBajaUsuarioClase();
	private ServicioActualizacionUsuarioClase servicioActualizacionUsuario = new ServicioActualizacionUsuarioClase();
	private ServicioGenerarHorasClase servicioGenerarHoras = new ServicioGenerarHorasClase();
	private ServicioGenerarPedidoClase servicioGenerarPedido = new ServicioGenerarPedidoClase();
	private ServicioVentasClase servicioVentas = new ServicioVentasClase();
	private ServicioConsultaRapidaClase servicioConsultaRapida = new ServicioConsultaRapidaClase();
	private ServicioVentaTotalClase servicioVentaTotal = new ServicioVentaTotalClase();
	private ServicioGenerarHoraEntradaClase servicioVentanaHoraEntrada = new ServicioGenerarHoraEntradaClase();
	private ServicioGenerarHoraSalidaClase  servicioVentanaHoraSalida = new ServicioGenerarHoraSalidaClase();
	private ServicioAltaProveedorClase servicioAltaProveedor = new ServicioAltaProveedorClase();
	private ServicioBajaProveedorClase servicioBajaProveedor = new ServicioBajaProveedorClase();
	private ServicioConsultaProveedoresClase servicioConsultaProveedor = new ServicioConsultaProveedoresClase();
	private ServicioReporteMesClase servicioReporteMes = new ServicioReporteMesClase();
	private ServicioRegistroGastosClase servicioRegistroGastos = new ServicioRegistroGastosClase();
	private ServicioReporteGastosClase servicioReporteGastos = new ServicioReporteGastosClase();
	private ServicioActualizacionProveedoresClase servicioActualizaProveedor = new ServicioActualizacionProveedoresClase();
	private ServicioVentanaPrincipalAdminClase servicioVentanaPrincipaladmin = new ServicioVentanaPrincipalAdminClase();
	private ServicioGastosClase servicioGastos = new ServicioGastosClase() ;
	
	
	//Ventanas
	private VentanaPrincipalAdmin ventanaPrincipalAdmin = new VentanaPrincipalAdmin(this);
	private VentanaPrincipal ventana = new VentanaPrincipal(this);
	private VentanaProductos productos = new VentanaProductos(this);
	private VentanaUsuarios usuarios = new VentanaUsuarios(this);
	private VentanaProveedores proveedores = new VentanaProveedores(this);
	private VentanaGenerarReportes reportes = new VentanaGenerarReportes(this);
	private VentanaHoras horas= new VentanaHoras(this);
	private VentanaGastos gastos = new VentanaGastos(this);
	//Main
	public static void main(String[] args){
		Aplicacion app = new Aplicacion();
		app.inicia();
	}

	public Aplicacion() {
		
    }
	
	//Inicia todo el sistema, mostrando la ventana principal
	public void inicia(){
	    ventana.setVisible(true);
	}
	
	public void ventanaPrincipal(){
		ventana.setVisible(true);
	}
	
	//Un proceso para cada caso de uso en el sistema
	//Cada proceso tiene su respectivo inicia. Se le mandan los dao que este requiera 
	public void login(int op){
		servicioLogin.inicia(op);
		servicioLogin.servicioLogin(ventana, productos, usuarios, proveedores,reportes, daoUsuario, ventanaPrincipalAdmin);
	}
	
	public void productos(){
		//login(1);
		productos.setVisible(true);
	}
	
	public void usuarios(){
		//login(2);
		usuarios.setVisible(true);
	}
	
	public void proveedores(){
		//login(4);
		proveedores.setVisible(true);
	}
	
	public void reportes(){
		//login(3);
		reportes.setVisible(true);
	}
	
	public void altaProductos(){
		servicioAltaProducto.inicia();
		servicioAltaProducto.servicioAltaProducto(daoProducto);
	}
	
	public void bajaProductos(){
		servicioBajaProducto.inicia();
		servicioBajaProducto.servicioBajaProducto(daoProducto);
	}
	
	public void actualizacionProductos(){
		servicioActualizacionProducto.inicia();
		servicioActualizacionProducto.servicioActualizacionProducto(daoProducto);
	}
	
	public void actualizacionPorLotes(){
		servicioActualizacionPorLotes.inicia();
		servicioActualizacionPorLotes.servicioActualizacionPorLote(daoProducto);
	}
	
	public void altaUsuarios(){
		servicioAltaUsuario.inicia();
		servicioAltaUsuario.servicioAltaUsuario(daoUsuario);
	}
	
	
	public void bajaUsuarios(){
		servicioBajaUsuario.inicia();
		servicioBajaUsuario.servicioBajaUsuario(daoUsuario);
	}
	
	public void actualizacionUsuarios(){
		servicioActualizacionUsuario.inicia();
		servicioActualizacionUsuario.servicioActualizacionUsuario(daoUsuario);
	}
		
	public void altaProveedores(){
		servicioAltaProveedor.inicia();
	}
	
	public void bajaProveedores(){
		servicioBajaProveedor.inicia();
	}
	
	public void consultaProveedores(){
		servicioConsultaProveedor.inicia();
	}
	
	public void generarHoras(){
		servicioGenerarHoras.inicia();
		servicioGenerarHoras.servicioGenerarHorasClase(daoDiaLaborado);
	}
	public void HoraEntrada(){
		servicioVentanaHoraEntrada.inicia();

	}
	
	public void HoraSalida(){
		servicioVentanaHoraSalida.inicia();
	}
	
	public void registrarHoras(){
		 horas= new VentanaHoras(this);
		 horas.setVisible(true);
	}
	
	public void generarPedido(){
		servicioGenerarPedido.inicia();
		servicioGenerarPedido.servicioGenerarPedido(daoProducto);
	}
	
	public void reportesVentasDia(){
		servicioVentaTotal.inicia();
		servicioVentaTotal.servicioVentaTotal(daoVenta, daoHistorial);
	}
	
	public void consultaRapida(){
		servicioConsultaRapida.inicia();
		servicioConsultaRapida.servicioConsultaRapida(daoProducto);
	}
	
	public void ventas(){
		servicioVentas.inicia();
		servicioVentas.servicioVentas(daoVenta, daoProducto);
		
	}
	
	public void reporteMes(){
		servicioReporteMes.inicia();
	}
	public void registroGastos(){
		servicioRegistroGastos.inicia();
	}
	public void reporteGastos(){
		servicioReporteGastos.inicia();
	}
	public void actualizaProveedores(){
		servicioActualizaProveedor.inicia();
	}
	public void ventanaAdmin(){
		login(5);
	}
	public void gastos(){
		gastos.setVisible(true);
	}
}
