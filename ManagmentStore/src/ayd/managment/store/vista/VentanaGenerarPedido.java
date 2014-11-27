package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.servicio.clase.ServicioGenerarPedidoClase;

//Heredo de VentanaGenerica
public class VentanaGenerarPedido extends VentanaGenerica{
	// Variables de clase
	private ServicioGenerarPedidoClase generaPedido;
	// ComboBox de proveedores 
	JComboBox<Object> cbxProveedor = new JComboBox<Object>();
	// Botones de la clase
	private JButton btnDescargarPedido = new JButton();
	private JButton btnGenerarPedido = new JButton("Generar Pedido");
	// Variables de la tabla
	private JTable productos = new JTable();
	private DefaultTableModel model;
	private JScrollPane barra;
	
	public VentanaGenerarPedido(ServicioGenerarPedidoClase control){
		super("Generar pedido","Regresar a ventana \"Principal\"");
		generaPedido = control;	
		
		// Aplica formato de componentes
		formatoComponentes();
		// Incializa formato de la tabla que muestra productos de baja existencia
		formatoTabla();
		// Agrega componentes a la ventana
		insertaEnPanel();
		// Carga comboBox en la ventana
		carga_ComboProveedor();
		
		// Accion de comboBox de proveedores
		cbxProveedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(cbxProveedor.getSelectedIndex()!=0){
            		limpiarJTable();
            		btnGenerarPedido.setEnabled(true);
            		btnDescargarPedido.setEnabled(false); 
            	}	
            }
        });
		
		// Accion del boton Generar pedido
		btnGenerarPedido.setFont(new Font("Dialog", Font.BOLD, 30));
		btnGenerarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarJTable();
				muestraTablaProductos((String) cbxProveedor.getSelectedItem());
				btnGenerarPedido.setEnabled(false);
			}
		});
		
		// Accion del boton Descargar Pedido
		btnDescargarPedido.setText("Descargar");
		btnDescargarPedido.setFont(new Font("Dialog", Font.BOLD, 30));
		btnDescargarPedido.setBounds(100, 100, 50, 50);
		btnDescargarPedido.setEnabled(false);
		btnDescargarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				btnDescargarPedido.setEnabled(false);
				btnGenerarPedido.setEnabled(false);
				cbxProveedor.setSelectedIndex(0); 
				ventana.dispose();
				limpiarJTable();
			}
		});
		
		// Accion del boton Salir
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 30));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarJTable();
				cbxProveedor.setSelectedIndex(0);
				carga_ComboProveedor();
				ventana.dispose();
			}
		});
	}
	
	// Formato de componenetes
	private void formatoComponentes(){
		btnGenerarPedido.setEnabled(false);
		cbxProveedor.setFont(new Font("Dialog", Font.BOLD , 28));
	}
	
	// Inserta los componentes en la ventana
	private void insertaEnPanel(){
		panel2.setLayout(new BorderLayout());
		panel2.add(cbxProveedor, BorderLayout.NORTH);
		panel2.add(barra, BorderLayout.CENTER);
		panel3.add(btnDescargarPedido, BorderLayout.NORTH);
		panel3.add(btnGenerarPedido, BorderLayout.WEST);
	}
	
	// Formato de tabla de productos de baja existencia
	private void formatoTabla(){
		model = new DefaultTableModel(); // Definimos el objeto tableModel
		productos = new JTable(); // Creamos la instancia de la tabla
		productos.setModel(model); // Fijamos el modelo
		barra = new JScrollPane( productos );
		productos.setFont(new Font("Dialog", Font.BOLD, 28));
		productos.setRowHeight(30);
		model.addColumn("Nombre del Producto");
		model.addColumn("Cantidad");
		productos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		productos.getTableHeader().setReorderingAllowed(true);
	}

	// Vacia tabla de productos
	private void limpiarJTable(){
		if(productos!=null){
        int a =model.getRowCount()-1;
	        for(int i=a;i>=0;i--) 
	            model.removeRow(i);	
		}
    }
	
	// Carga comboBox de Proveedores
	public void carga_ComboProveedor(){
		/*int i=0;
		String[] proveedores = generaPedido.regresaProveedores();
		String[]  modelProveedores = new String[proveedores.length+1];
		Arrays.sort(proveedores);
		modelProveedores[0]= "Selecciona Proveedor: ";
		for(i=0;  i < proveedores.length ; i++)
			modelProveedores[i+1] = proveedores[i];
		cbxProveedor.setModel(new javax.swing.DefaultComboBoxModel<Object>(modelProveedores));
		cbxProveedor.setSelectedIndex(0);  
		*/
	}
	
	// Muestra tabla de pedidos de baja existencia sino hay entonces muestra mensaje
	private void muestraTablaProductos(String proveedor){ 
		Producto[] productos = generaPedido.productosProveedor(proveedor);
		// Si no hay productos en la lista y lanza mensaje de error
		if(productos == null){
			JOptionPane.showMessageDialog(ventana, "No hay productos de baja existencia para: "+cbxProveedor.getSelectedItem());
			cbxProveedor.setSelectedIndex(0);
		}
		else{
			if(productos.length ==0){
				JOptionPane.showMessageDialog(ventana, "No hay productos de baja existencia para: "+cbxProveedor.getSelectedItem());
				cbxProveedor.setSelectedIndex(0); 
			}	
			else{
				for(Producto p: productos){
					// Obtiene la cantidad para mostrarla en pantalla
					float cantidad = p.getExistenciaMaxima() - p.getExistenciaActual();
					model.addRow(new Object[] {p.getNombre(), cantidad});
					btnDescargarPedido.setEnabled(true);
				}
				// Si hay productos habilita el botón descargar 	
				btnDescargarPedido.setEnabled(true);
			}
		}
	}		
}
