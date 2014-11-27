package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.Interface.ServicioConsultaProveedores;
import ayd.managment.store.servicio.Interface.ServicioConsultaRapida;

public class VentanaConsultaProveedores extends VentanaGenerica{
	//Variables de la clase
		private ServicioConsultaProveedores servicioConsultaProveedores;
		private DefaultTableModel modeloProveedores = new DefaultTableModel(){
		
	   public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
		}; 
		//Tablas	
		private JTable tblProveedores = new JTable(modeloProveedores);
		private TableColumn columnaProveedores = new TableColumn();
		//Scrolls
		private JScrollPane scrollProveedores = new JScrollPane(tblProveedores);
		//Paneles
		private JPanel panel21 = new JPanel();
		private JPanel panel22 = new JPanel();
		private JButton btnConsultaProveedor = new JButton("Consultar");
		private Proveedor[] proveedores;
		
		private ArrayList<String[]> datosL = new ArrayList<String[]>();
		//Construcctor
		public VentanaConsultaProveedores(ServicioConsultaProveedores control){
			super("Consulta de Proveedores","Regresar a ventana \"Proveedores\"");
			servicioConsultaProveedores = control;
			
			colocaFormato();
			ordenaElementos();
			btnConsultaProveedor.setFont(new Font("Dialog", Font.BOLD, 30));
			
			btnConsultaProveedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Proveedor [] prov=servicioConsultaProveedores.despliegaProv();
					if(prov==null){
						JOptionPane.showMessageDialog(ventana, "no hay proveedores");
					}else{
						for(int i=0;i<prov.length;i++){
							String[] aux= new String[3];
							aux[0]=prov[i].getProveedor();
							aux[1]=prov[i].getTelefono();
							aux[2]=prov[i].getTipo();
							modeloProveedores.addRow(aux);
						}
					}
				}
			});
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(int i=modeloProveedores.getRowCount()-1;i>=0;i--){
						modeloProveedores.removeRow(i);
					}
				}
			});
		}
		

		
		//Metodo que coloca el formato de la tabla
		private void colocaFormato(){
			panel21.setBackground(UIManager.getColor("Button.focus"));
			panel22.setBackground(UIManager.getColor("Button.focus"));
			tblProveedores.setFont(new Font("Dialog", Font.BOLD, 28));
			tblProveedores.setRowHeight(30);
			modeloProveedores.addColumn("Nombre");
			modeloProveedores.addColumn("Teléfono");
			modeloProveedores.addColumn("Tipo");
			columnaProveedores.setPreferredWidth(600);
		}
		//Metodo que ordena los elementos de la ventana de busqeda
		public void ordenaElementos(){
			panel2.setLayout(new BorderLayout(0, 20));
			panel2.add(panel21, BorderLayout.NORTH);
			panel2.add(panel22, BorderLayout.CENTER);
			panel21.setLayout(new GridLayout(1, 2, 0, 0));
			panel22.setLayout(new BorderLayout(0, 20));
			panel22.add(scrollProveedores);
			panel3.add(btnConsultaProveedor, BorderLayout.WEST);
		}
		
		
		/*
		private void despliegaDatosNombre(){
			datosL = servicioConsultaProveedores.mostrarDatosLista();
			for(indice = 0; indice < datosL.size(); indice++)
				modeloProductos.addRow(new String [] {datosL.get(indice)[0], datosL.get(indice)[1], datosL.get(indice)[2]);
			datosL = null;
		}
		
		*/

}
