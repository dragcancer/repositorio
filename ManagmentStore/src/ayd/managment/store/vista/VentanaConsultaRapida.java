package ayd.managment.store.vista;

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
	private void buscar(String criterio){
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
}
