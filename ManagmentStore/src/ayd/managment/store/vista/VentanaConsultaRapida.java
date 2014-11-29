package ayd.managment.store.vista;
/*
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ayd.managment.store.servicio.Interface.ServicioConsultaRapida;

//Heredo de VentanaGenerica
public class VentanaConsultaRapida extends VentanaGenerica{
	//Variables de la clase
	private ServicioConsultaRapida servicioConsultaRapida;
	private JLabel lblBusqueda = new JLabel("Ingrese el nombre/código del producto:");
	private JTextField txtBusqueda = new JTextField("");
	private DefaultTableModel modeloProductos = new DefaultTableModel(){
	public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 
	//Tablas	
	private JTable tblProductos = new JTable(modeloProductos);
	private TableColumn columnaProductos = new TableColumn();
	//Scrolls
	private JScrollPane scrollProductos = new JScrollPane(tblProductos);
	//Paneles
	private JPanel panel21 = new JPanel();
	private JPanel panel22 = new JPanel();
	//Variables de la clase
	private int tecla;
	private int indice;
	private String datosC[] = new String[6];
	private ArrayList<String[]> datosL = new ArrayList<String[]>();
	//Construcctor
	public VentanaConsultaRapida(ServicioConsultaRapida control){
		super("Consulta rápida","Regresar a ventana \"Principal\"");
		servicioConsultaRapida = control;
		
		colocaFormato();
		ordenaElementos();
		
		txtBusqueda.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaCadenayEntero(txtBusqueda.getText(), e);
			}
		});
		
		txtBusqueda.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(!txtBusqueda.getText().isEmpty()){
					while(modeloProductos.getRowCount()>0)
						modeloProductos.removeRow(0);
					buscar(txtBusqueda.getText());		
				}
				else{
					while(modeloProductos.getRowCount()>0)
						modeloProductos.removeRow(0);
				}
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiaCampos();
			}
		});
	}
	//Metodo que coloca el formato de la tabla
	private void colocaFormato(){
		panel21.setBackground(UIManager.getColor("Button.focus"));
		panel22.setBackground(UIManager.getColor("Button.focus"));
		tblProductos.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBusqueda.setFont(new Font("Dialog", Font.BOLD, 28));
		txtBusqueda.setFont(new Font("Dialog", Font.BOLD, 28));
		tblProductos.setRowHeight(30);
		modeloProductos.addColumn("Producto");
		modeloProductos.addColumn("Precio menudeo");
		modeloProductos.addColumn("Precio mayoreo");
		modeloProductos.addColumn("Cantidad mayoreo");
		modeloProductos.addColumn("Existencia");
		columnaProductos = tblProductos.getColumn("Producto");
		columnaProductos.setPreferredWidth(600);
	}
	//Metodo que ordena los elementos de la ventana de busqeda
	public void ordenaElementos(){
		panel2.setLayout(new BorderLayout(0, 20));
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel22, BorderLayout.CENTER);
		panel21.setLayout(new GridLayout(1, 2, 0, 0));
		panel21.add(lblBusqueda);
		panel21.add(txtBusqueda);	
		panel22.setLayout(new BorderLayout(0, 20));
		panel22.add(scrollProductos);
	}
	//Valida los elementos en el campo de texto, solo permitiendo la escritura de letras y numeros
	private void  validaCadenayEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 33 && tecla <= 45 || tecla == 47 || tecla >= 58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
	    	e.consume();
	}
	//Elimia el campo de texto y la tabla
	private void limpiaCampos(){
		while(modeloProductos.getRowCount()>0)
			modeloProductos.removeRow(0);
		txtBusqueda.setText("");
	}
	/*Este metodo realiza verifica si el argumento que se le pasa es un codigo o un nombre de producto y muestra
	 * y llama al metodo correcto para desplegar los datos
	 */
	/*private void buscar(String criterio){
		int r;
		r = servicioConsultaRapida.buscarProducto(criterio);
		if(r == 1)
			despliegaDatosCodigo();			
		else
			despliegaDatosNombre();	
		
	}
	//Este metodo despliega los datos por nombre en la tabla
	private void despliegaDatosNombre(){
		datosL = servicioConsultaRapida.mostrarDatosLista();
		for(indice = 0; indice < datosL.size(); indice++)
			modeloProductos.addRow(new String [] {datosL.get(indice)[0], datosL.get(indice)[1], datosL.get(indice)[2], datosL.get(indice)[3], datosL.get(indice)[4]});
		datosL = null;
	}
	//Este metodo despliega los datos por codigo en la tabla
	private void despliegaDatosCodigo(){
		datosC = servicioConsultaRapida.mostrarDatos();
		modeloProductos.addRow(new String [] {datosC[0], datosC[1], datosC[2], datosC[3], datosC[4]});
		datosC = null;
	}
}*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import ayd.managment.store.modelo.Producto;
import ayd.managment.store.servicio.Interface.ServicioConsultaRapida;


public class VentanaConsultaRapida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableConsulta;
	private String[] datos;/*={{"1","Fernando","castillo"},
			{"2","Cecilia","Hernandez"},
			{"3","Karla","Martinez"},};*/
	private String [] cabecera={"Producto","Precio Unitario","Existencia"};
	private JButton Buscar;
	private JLabel codigoProducto;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private Producto[] productos;
	
	private DefaultTableModel modeloProductos = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 

	JButton Salir;
private ServicioConsultaRapida servicioConsultaRapida;
	public VentanaConsultaRapida(ServicioConsultaRapida control) {
		servicioConsultaRapida=control;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1249, 609, 2, 2);
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(scrollPane);
		set_Table();
		
		tableConsulta = new JTable(modeloProductos);
		tableConsulta.setBounds(1253, 610, 1, 1);
		tableConsulta.setRowSelectionAllowed(false);
		contentPane.add(tableConsulta);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(320, 29, 898, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(232, 25, 627, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		codigoProducto = new JLabel("Codigo de Producto:");
		codigoProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		codigoProducto.setBounds(31, 21, 169, 24);
		panel.add(codigoProducto);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 22, 272, 573);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Buscar = new JButton("");
		Buscar.setBounds(10, 11, 252, 250);
		panel_1.add(Buscar);
		Buscar.setToolTipText("Buscar");
		Buscar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\search-icon.png"));
		
		Salir = new JButton("");
		Salir.setBounds(10, 312, 252, 250);
		panel_1.add(Salir);
		Salir.setToolTipText("Salir");
		Salir.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Log-Out-icon.png"));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_2.setBounds(320, 128, 895, 467);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		modeloProductos.addColumn("Producto");
		modeloProductos.addColumn("Precio menudeo");
		modeloProductos.addColumn("Precio mayoreo");
		modeloProductos.addColumn("Cantidad mayoreo");
		modeloProductos.addColumn("Existencia");
		
		productos=servicioConsultaRapida.getProductos();
			for(int j=0;j<productos.length;j++){
				datos= new String[5];
				datos[0]=""+productos[j].getNombre();
				datos[1]=""+productos[j].getPrecioMenudeo();
				datos[2]=""+productos[j].getPrecioMayoreo();
				datos[3]=""+productos[j].getCantidadMayoreo();
				datos[4]=""+productos[j].getExistenciaActual();
				modeloProductos.addRow(datos);
			}
			
		//tableConsulta =new JTable(datos,cabecera);
		JScrollPane js=new JScrollPane (tableConsulta);
		js.setViewportBorder(new TitledBorder(null, "", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
		js.setBounds(10, 11, 875, 445);
		panel_2.add(js);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//limpiarCampos();
				dispose();
			}
		});
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int band=0;
				String[] prod= new String[5];
				if(!textField.getText().equals("")){
				for(int i=0;i<productos.length;i++){
					String nom=productos[i].getNombre();
					if(nom.contains(textField.getText())){
						band=1;
						prod[0]=""+productos[i].getNombre();
						prod[1]=""+productos[i].getPrecioMenudeo();
						prod[2]=""+productos[i].getPrecioMayoreo();
						prod[3]=""+productos[i].getCantidadMayoreo();
						prod[4]=""+productos[i].getExistenciaActual();
						break;
						
					}
				}
				if(band==1){
					for(int i=modeloProductos.getRowCount()-1;i>=0;i--){
						modeloProductos.removeRow(i);
					}
					modeloProductos.addRow(prod);
				
				}else{
					JOptionPane.showMessageDialog(null, "no existe producto");
				}
				}else{
					JOptionPane.showMessageDialog(null, "no ha puesto un producto a buscar");
				}
			}
		});
	}

	public void set_Table(){
	}
}

