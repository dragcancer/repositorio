package ayd.managment.store.vista;
/*
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
				limpiarJTable();
			}
		});
		
		// Accion del boton Salir
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 30));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//limpiarJTable();
				//cbxProveedor.setSelectedIndex(0);
				//carga_ComboProveedor();
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
	//}
	/*
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
}*/


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;

import javax.swing.border.EtchedBorder;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import ayd.managment.store.modelo.Historial;
import ayd.managment.store.modelo.Producto;
import ayd.managment.store.persistencia.Intercafe.DAOHistorial;
import ayd.managment.store.persistencia.Intercafe.DAOVenta;
import ayd.managment.store.persistencia.clase.DAOHistorialClase;
import ayd.managment.store.persistencia.clase.DAOVentaClase;
import ayd.managment.store.servicio.clase.ServicioGenerarPedidoClase;

public class VentanaGenerarPedido extends JFrame {
	private DefaultTableModel model= new DefaultTableModel();
	private JPanel contentPane;
	private JTable tablaPedido= new JTable(model);
private JButton Buscar;
private JScrollPane scrollTabla;
private JTextField Proveedor;
private JButton generarPedido;

private JScrollPane js;
private JPanel panel;
private JPanel panel_1;
private ServicioGenerarPedidoClase generaPedido;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGenerarPedido frame = new VentanaGenerarPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public VentanaGenerarPedido(ServicioGenerarPedidoClase control) {
		this.generaPedido=control;
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\ManagmentStore\\Iconos\\Places-user-identity-icon.png"));
		setTitle("Generar Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollTabla = new JScrollPane();
		scrollTabla.setBounds(922, 105, -16, 360);
		contentPane.add(scrollTabla);
		set_Table();
		

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(10, 11, 223, 605);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Buscar = new JButton("");
		Buscar.setBounds(10, 11, 203, 183);
		panel.add(Buscar);
		Buscar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\search-icon.png"));
		
		generarPedido = new JButton("");
		generarPedido.setBounds(10, 205, 203, 189);
		panel.add(generarPedido);
		generarPedido.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\checklist-icon.png"));
		
		JButton Descargar = new JButton("");
		Descargar.setBounds(10, 405, 203, 189);
		panel.add(Descargar);
		Descargar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Files-Download-File-icon.png"));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(0, 0, 1300, 662);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(264, 21, 989, 72);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel SeleccioneProveedor = new JLabel("Seleccione Proveedor:");
		SeleccioneProveedor.setBounds(-55, 19, 353, 14);
		panel_2.add(SeleccioneProveedor);
		SeleccioneProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SeleccioneProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		model.addColumn("Nombre del Producto");
		model.addColumn("Cantidad");
		Proveedor = new JTextField(200);
		Proveedor.setBounds(233, 11, 740, 27);
		panel_2.add(Proveedor);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder());
		panel_3.setBounds(264, 135, 989, 473);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		tablaPedido.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		js=new JScrollPane (tablaPedido);
		js.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		js.setBounds(10, 11, 969, 450);
		panel_3.add(js);
		
		js.setPreferredSize(new Dimension(400,150));
		
		Buscar.setToolTipText("Buscar");
		generarPedido.setToolTipText("Generar pedido");
		Descargar.setToolTipText("Salir");
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//limpiarCampos();
				Producto[] prod;
				String[] auxprod= new String[2];
				if(!Proveedor.getText().equals("")){
					prod=generaPedido.productosProveedor(Proveedor.getText());
					if(prod!=null){
						for(int i=0;i<prod.length;i++){
							auxprod[0]=prod[i].getNombre();
							auxprod[1]=""+prod[i].getExistenciaActual();
							model.addRow(auxprod);
						}
					}else{
						Proveedor.setText("");
						JOptionPane.showMessageDialog(null, "no existe ese proveedor");
					}
				}else{
					JOptionPane.showMessageDialog(null, "no ha dado un proveedor");
				}
			}
		});
		

		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				limpiarJTable();
				Proveedor.setText("");
				dispose();
			}
		});
		
		generarPedido.setFont(new Font("Dialog", Font.BOLD, 30));
		generarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(model.getRowCount()!=0){
				String[] productos= new String[model.getRowCount()];
				String[] cantidad= new String[model.getRowCount()];
				for(int i=0;i<productos.length;i++){
					productos[i]=""+model.getValueAt(i, 0);
					cantidad[i]=""+model.getValueAt(i, 1);
					generaPedido.generarPdf(productos, cantidad);
				}
				limpiarJTable();
				Proveedor.setText("");
			}
			else{
				JOptionPane.showMessageDialog(null, "no hay pedido que generar");
			}
			}});
	}
	private void limpiarJTable(){
        int a =model.getRowCount()-1;
	        for(int i=a;i>=0;i--) 
	            model.removeRow(i);	
    }

	
	public void set_Table(){
		
	}
}
