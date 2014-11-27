package ayd.managment.store.servicio.clase;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.modelo.Venta;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;
import ayd.managment.store.servicio.Interface.ServicioVentas;
import ayd.managment.store.vista.VentanaVentas;

public class ServicioVentasClase implements ServicioVentas{

	private DAOVenta daoVenta;
	private DAOProducto daoProducto;
	private VentanaVentas ventana = new VentanaVentas(this);
	private Venta venta;
	private Producto producto;
	private Producto[] productos;
	private float total = 0;
	private int indice;
	private int indice2;
	private boolean esNumero;
	private Date fecha;
	ArrayList<Producto> productosVenta = new ArrayList<Producto>();
	 public static String archivo=System.getProperty("user.dir")+"/archivo.pdf";
	
	//Recibe los daos de ventas y producto
	public void servicioVentas(DAOVenta daoVenta,DAOProducto daoProducto){
		this.daoVenta = daoVenta;
		this.daoProducto = daoProducto;
	}
	
	//muestra la ventana de ventas
	public void inicia(){
	    ventana.setVisible(true);
	}
		
	/*
	 * Recibe un criterio de bÃºsqueda (nombre) de un producto a vender, 
	 * si la operaciÃ³n se realiza con Ã©xito regresa un booleano = True, en otro caso booleano = False.
	 */
	public boolean buscarProductoNombre(String nombre){
		
		if(daoProducto.cuantosProductos() == 0)
			return false;
		else{
			productos = daoProducto.retriveNombreParcial(nombre);
			if(productos == null){
				return false;
			}
			else{
				if(productos.length != 0)
					return true;
				else
					return false;
			}
		}
	}
	
	/*
	 * Recibe un criterio de bÃºsqueda (cÃ³digo) de un producto a vender, 
	 * si la operaciÃ³n se realiza con Ã©xito regresa un booleano = True, en otro caso booleano = False.
	 */
	public boolean buscarProductoCodigo(String codigo){
		if(daoProducto.cuantosProductos() == 0)
			return false;
		else{
			try{
				//aqui se decide si se hara retrive por codigo o nombre
				Integer.parseInt(codigo);	
				esNumero = true;
			}catch(NumberFormatException ex){
				esNumero = false;
			}
			if(esNumero)
				producto = daoProducto.retriveCodigo(codigo);
			if(producto != null)
				return true;
			else
				return false;
		}
	}
	
	/*
	 * Regresa un arreglo de cadenas con los datos de un producto que se desea vender,
	 * para mostrarlos en la vista â€œVentasâ€�.
	 */
	//solo regresa un producto
	public String[] mostrarDatos(){
		String datos[] = new String[6];
		datos[0] = producto.getNombre();
		datos[1] = producto.getPrecioMenudeo()+"";
		datos[2] = producto.getPrecioMayoreo()+"";
		datos[3] = producto.getCantidadMayoreo()+"";
		datos[4] = producto.getExistenciaActual()+"";
		datos[5] = producto.getTipo()+"";
		producto = null;
		return datos;
	}
	
	//regresa todos los productos que tengan una conicidencia en el nombre
	//con el producto que se esta buscando
	public ArrayList<String[]>  mostrarDatosLista(){
		ArrayList<String[]> datosProductos = new ArrayList<String[]>();
		for(indice = 0; indice < productos.length; indice++){
			String p[] = new String[6];
			p[0] = productos[indice].getNombre();
			p[1] = productos[indice].getPrecioMenudeo()+"";
			p[2] = productos[indice].getPrecioMayoreo()+"";
			p[3] = productos[indice].getCantidadMayoreo()+"";
			p[4] = productos[indice].getExistenciaActual()+"";
			p[5] = productos[indice].getTipo()+"";
			datosProductos.add(p);
		}
		productos = null;
		return datosProductos;
	}
	
	/*
	 * recibe un arreglo de productos y regresa un entero para avisar si la existencia es vÃ¡lida.
	 * si int = 0 todos los productos son validos, 
	 * en otro caso el producto numero â€œintâ€� en la lista no es vÃ¡lido en existencia.
	 */
	public int realizarVenta(ArrayList<String[]> Productos){
		float cantidadVenta = 0;
		float totalVenta = 0;
		total = 0;
		while(!productosVenta.isEmpty())
			productosVenta.remove(0);
		for(indice = 0; indice < Productos.size(); indice++){
			productosVenta.add(daoProducto.retriveNombre(Productos.get(indice)[0]));
		}
		//0 nombre // 1 preciom // 2 precioM // 3 cantidadM // 4 cantidadV // 5 total
		for(indice = 0; indice < productosVenta.size(); indice++){
			try{
				cantidadVenta = Float.parseFloat(Productos.get(indice)[4]);	
			}catch(NumberFormatException ex){
				break;
			}
			if(productosVenta.get(indice).getExistenciaActual() < cantidadVenta){
				break;
			}
		}
		if(indice < productosVenta.size())
			return indice;
		else{
			for(indice2 = 0; indice2 < productosVenta.size(); indice2++){
				try{
					cantidadVenta = Float.parseFloat(Productos.get(indice2)[4]);	
					totalVenta = Float.parseFloat(Productos.get(indice2)[5]);	
				}catch(NumberFormatException ex){
				}
				productosVenta.get(indice2).setExistenciaActual(productosVenta.get(indice2).getExistenciaActual() - cantidadVenta);
				total = total + totalVenta;
			}
			return -1;
		}
	}
	
	/*
	 * Calcula el total a pagar en una venta, regresa el respectivo total.
	 */
	public float muestraTotal(){
		return total;
	}
	
	/*
	 * Guarda una venta que ha sido confirmada,
	 * regresa un booleano = true si la operaciÃ³n fue exitosa, en otro caso booleano = false.
	 */
	public boolean guardarVenta(){
		boolean exito;
		for(indice = 0; indice < productosVenta.size(); indice++){
			if(daoProducto.updateVenta(productosVenta.get(indice)))
				exito = true;
			else{
				exito = false;
				break;
			}
		}
		while(!productosVenta.isEmpty())
			productosVenta.remove(0);
		venta = new Venta(generarFecha()[0],generarFecha()[1],total);
		if(daoVenta.create(venta)){
			venta = null;
			exito = true;
		}
		else
			exito = false;
		if(exito)
			return true;
		else
			return false;
	}
	
	public boolean guardarVentaPDF(){
		Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
		PdfWriter writer = null;
		 try {      
		    writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
		    documento.addTitle("Tiket de compra");
	    	documento.addAuthor("hug0");
	    	documento.open();
	    	Paragraph parrafo = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_CENTER);
	    	parrafo.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
	    	parrafo.add("Gracias Por Su Compra\n");
	    	Paragraph parrafo1 = new Paragraph();
	    	parrafo1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	    	parrafo1.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
	    	parrafo1.add("\nNOMBRE"+"               "+"PRECIO");
	    	
	    	Paragraph ventas = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
	    	ventas.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLACK));
	    	float acumulado=0;
	    	for(indice = 0; indice < productosVenta.size(); indice++){
	    		ventas.add(productosVenta.get(indice).getNombre()+"      "+productosVenta.get(indice).getPrecioCompra()+"\n");   	
	    		acumulado=acumulado+productosVenta.get(indice).getPrecioCompra();
	    	}
	    	ventas.add("Precio total a pagar:      "+acumulado);
	      	documento.add(parrafo);
	      	documento.add(parrafo1);
	      	documento.add(ventas);
	      	documento.close(); 
	    	writer.close(); 
	    	return true;
		} catch (Exception ex) {
			ex.getMessage();
			return true;
		}
	}
	
	
	//toma la fecha del sistema, para utilizarla al guardar uan venta exitosa
	@SuppressWarnings("deprecation")
	private String[] generarFecha(){
		fecha = new Date();
		String DateAndTime[] = new String[2];
		DateAndTime[0] = String.format("%04d-%02d-%02d",fecha.getYear()+1900,fecha.getMonth()+1,fecha.getDate()); 
		DateAndTime[1] = String.format("%02d:%02d:%02d",fecha.getHours(),fecha.getMinutes(),fecha.getSeconds()); 
		return DateAndTime;
	}	
}
