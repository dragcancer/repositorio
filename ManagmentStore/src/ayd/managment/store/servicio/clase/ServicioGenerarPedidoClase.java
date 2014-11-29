package ayd.managment.store.servicio.clase;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOProducto;
import ayd.managment.store.persistencia.clase.DAOProductoClase;
import ayd.managment.store.servicio.Interface.ServicioGenerarPedido;
import ayd.managment.store.vista.VentanaGenerarPedido;

public class ServicioGenerarPedidoClase implements ServicioGenerarPedido{
	
	
	private DAOProducto daoProducto = new DAOProductoClase();
	private VentanaGenerarPedido ventana = new VentanaGenerarPedido(this);
	public static String archivo=System.getProperty("user.dir")+"/Pedido.pdf";
	
	public void servicioGenerarPedido(DAOProducto  daoProducto){
		this.daoProducto = daoProducto;
	}
	
	// Muestra ventana de GenerarPedido
	public void inicia(){
			ventana.setVisible(true);
		//	ventana.carga_ComboProveedor();
	}
	
	// Regresa todos los proveedores registrados
	public String[] regresaProveedores(){
		return daoProducto.proveedores();
	}
	
	// Regresa todos los productos de baja existencia del proveedor que se le pase como parametro
	public Producto[] productosProveedor(String proveedor){
		Producto[] productosP = daoProducto.buscaProductosProveedor(proveedor);
		ArrayList<Producto> bajaExistencia = new ArrayList<Producto>();
		Producto[] existenciaBajaProductos = null;
		for(Producto producto: productosP)
			if(producto.getExistenciaActual() <= producto.getExistenciaMinima()){
				bajaExistencia.add(producto);
			}	
		if (bajaExistencia.size() != 0){
			existenciaBajaProductos = new Producto[bajaExistencia.size()];
			bajaExistencia.toArray(existenciaBajaProductos);
		}
		return existenciaBajaProductos;
	}

	public boolean generarPdf(String[] productos, String[] cantidad){
		Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
		PdfWriter writer = null;
		 try {      
		    writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
		    documento.addTitle("Pedido");
	    	documento.addAuthor("hug0");
	    	documento.open();
	    	Paragraph parrafo = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_CENTER);
	    	parrafo.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
	    	Paragraph parrafo1 = new Paragraph();
	    	parrafo1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	    	parrafo1.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
	    	parrafo1.add("\nNOMBRE"+"               "+"CANTIDAD");
	    	
	    	Paragraph pedido = new Paragraph();
	    	parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
	    	pedido.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLACK));
	    	float acumulado=0;
	    	int indice;
	    	for(indice = 0; indice < productos.length; indice++){
	    		pedido.add(productos[indice]+"                 "+cantidad[indice]+"\n");

	    	}
	      	documento.add(parrafo);
	      	documento.add(parrafo1);
	      	documento.add(pedido);
	      	documento.close(); 
	    	writer.close(); 
	    	return true;
		} catch (Exception ex) {
			ex.getMessage();
			return true;
		}
	}

}

