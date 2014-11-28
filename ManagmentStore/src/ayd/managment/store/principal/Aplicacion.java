package ayd.managment.store.principal;
import ayd.managment.store.persistencia.clase.DAODiaLaboradoClase;
import ayd.managment.store.persistencia.clase.DAOHistorialClase;
import ayd.managment.store.persistencia.clase.DAOProductoClase;
import ayd.managment.store.persistencia.clase.DAOUsuarioClase;
import ayd.managment.store.persistencia.clase.DAOVentaClase;
import ayd.managment.store.persistencia.clase.MyDataAcces;
import ayd.managment.store.servicio.Interface.*;
import ayd.managment.store.servicio.clase.ServicioActualizacionPorLotesClase;
import ayd.managment.store.servicio.clase.ServicioActualizacionProductoClase;
import ayd.managment.store.servicio.clase.ServicioActualizacionProveedoresClase;
import ayd.managment.store.servicio.clase.ServicioActualizacionUsuarioClase;
import ayd.managment.store.servicio.clase.ServicioAltaProductoClase;
import ayd.managment.store.servicio.clase.ServicioAltaProveedorClase;
import ayd.managment.store.servicio.clase.ServicioAltaUsuarioClase;
import ayd.managment.store.servicio.clase.ServicioBajaProductoClase;
import ayd.managment.store.servicio.clase.ServicioBajaProveedorClase;
import ayd.managment.store.servicio.clase.ServicioBajaUsuarioClase;
import ayd.managment.store.servicio.clase.ServicioConsultaProveedoresClase;
import ayd.managment.store.servicio.clase.ServicioConsultaRapidaClase;
import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;
import ayd.managment.store.servicio.clase.ServicioGenerarHoraSalidaClase;
import ayd.managment.store.servicio.clase.ServicioGenerarHorasClase;
import ayd.managment.store.servicio.clase.ServicioGenerarPedidoClase;
import ayd.managment.store.servicio.clase.ServicioLoginClase;
import ayd.managment.store.servicio.clase.ServicioRegistroGastosClase;
import ayd.managment.store.servicio.clase.ServicioReporteGastosClase;
import ayd.managment.store.servicio.clase.ServicioReporteMesClase;
import ayd.managment.store.servicio.clase.ServicioVentaTotalClase;
import ayd.managment.store.servicio.clase.ServicioVentasClase;
import ayd.managment.store.vista.VentanaGenerarReportes;
import ayd.managment.store.vista.VentanaHoras;
import ayd.managment.store.vista.VentanaPrincipal;
import ayd.managment.store.vista.VentanaProductos;
import ayd.managment.store.vista.VentanaProveedores;
import ayd.managment.store.vista.VentanaUsuarios;

public class Aplicacion {	
	//Variables de clase
	//DAOs
	//Bad word 123
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
	
	//Ventanas
	private VentanaPrincipal ventana = new VentanaPrincipal(this);
	private VentanaProductos productos = new VentanaProductos(this);
	private VentanaUsuarios usuarios = new VentanaUsuarios(this);
	private VentanaProveedores proveedores = new VentanaProveedores(this);
	private VentanaGenerarReportes reportes = new VentanaGenerarReportes(this);
	private VentanaHoras horas;
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
	
	//Un proceso para cada caso de uso en el sistema
	//Cada proceso tiene su respectivo inicia. Se le mandan los dao que este requiera 
	public void login(int op){
		servicioLogin.inicia(op);
		servicioLogin.servicioLogin(ventana, productos, usuarios, proveedores,reportes, daoUsuario);
	}
	
	public void productos(){
		login(1);
		//productos.setVisible(true);
	}
	
	public void usuarios(){
		login(2);
		//usuarios.setVisible(true);
	}
	
	public void proveedores(){
		login(4);
	}
	
	public void reportes(){
		login(3);
		//reportes.setVisible(true);
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
}
