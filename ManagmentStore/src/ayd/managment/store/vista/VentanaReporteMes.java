package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import ayd.managment.store.modelo.Venta;
import ayd.managment.store.servicio.Interface.ServicioReporteMes;

public class VentanaReporteMes  extends VentanaGenerica{
	//variables de clase
		private ServicioReporteMes servicioReporteMes;
		//botones
		private JButton btnGenerarReporte = new JButton("Reporte");
		private DefaultTableModel modeloVentas = new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
		}; 
		//Etiquetas
		private JLabel lblMes = new JLabel("Mes: ");
		private JLabel lblAnio = new JLabel("Año: ");
		private JLabel lblCantidad = new JLabel("Total de ventas: ");
		private JLabel lblTotal = new JLabel("Total: $");
		private JLabel label1 = new JLabel();
		private JLabel label2 = new JLabel();
		//Campos te texto
		private JTextField txtCantidad = new JTextField("");
		private JTextField txtTotal = new JTextField("");
		private JTextField txtAnio = new JTextField("2014");
	
		//Combox
		
		private JComboBox cbxMes = new JComboBox(new javax.swing.DefaultComboBoxModel(new String[] {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}));
		
		//Tablas
		private JTable tblVentas = new JTable(modeloVentas);
		//Scrolls
		private JScrollPane scrollVentas = new JScrollPane(tblVentas);
		//Paneles
		private JPanel panel21 = new JPanel();
		private JPanel panel22 = new JPanel();
		private JPanel panel23 = new JPanel();
		private JPanel panel3 = new JPanel();
		private JPanel panel4 = new JPanel();
		
		private ArrayList<String[]> datosVentas = new ArrayList<String[]>();
		private int indice;

		public VentanaReporteMes(ServicioReporteMes control){
			super("Reporte de Mes","Regresar a ventana \"Generar reportes\"");
			servicioReporteMes = control;
			colocaFormato();
			ordenaElementos();
			deshabilitaCampos();
			
			//busca todas las ventas realizadas en el dia y genera el reporte correspondiente
			btnGenerarReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//limpiaCampos();
					Venta[] ventas=servicioReporteMes.generarReporte(""+(cbxMes.getSelectedIndex()+1), txtAnio.getText());
					String[] aux= new String[4];
					int j=1;
					float acumulado=0;
					for(int i=0;i<ventas.length;i++){
						aux[0]=""+j;
						aux[1]=ventas[i].getFecha();
						aux[2]=ventas[i].getHora();
						aux[3]=""+ventas[i].getGanancia();
						acumulado=acumulado+ventas[i].getGanancia();
						modeloVentas.addRow(aux);
					}
					txtTotal.setText(""+acumulado);
					txtCantidad.setText(""+ventas.length);
				}
			});
			
			//una vez generado el reporte
			//guarda el total con la fecha en historial
						//boton salir
			//deja la ventana limpia
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					limpiaCampos();
				}
			});
		}
		
		//coloca el formato a los elementos de la ventana
		private void colocaFormato(){
			lblMes.setFont(new Font("Dialog", Font.BOLD, 28));
			lblAnio.setFont(new Font("Dialog", Font.BOLD, 28));
			cbxMes.setFont(new Font("Dialog", Font.BOLD, 28));
			txtAnio.setFont(new Font("Dialog", Font.BOLD, 28));
			lblCantidad.setFont(new Font("Dialog", Font.BOLD, 28));
			label2.setFont(new Font("Dialog", Font.BOLD, 68));
			btnGenerarReporte.setFont(new Font("Dialog", Font.BOLD, 28));
			panel21.setBackground(UIManager.getColor("Button.focus"));
			panel22.setBackground(UIManager.getColor("Button.focus"));
			panel23.setBackground(UIManager.getColor("Button.focus"));
			panel3.setBackground(UIManager.getColor("Button.focus"));
			panel4.setBackground(UIManager.getColor("Button.focus"));
			lblCantidad.setFont(new Font("Dialog", Font.BOLD, 28));
			lblTotal.setFont(new Font("Dialog", Font.BOLD, 28));
			txtCantidad.setFont(new Font("Dialog", Font.BOLD, 28));
			txtTotal.setFont(new Font("Dialog", Font.BOLD, 28));
			tblVentas.setFont(new Font("Dialog", Font.BOLD, 28));
			tblVentas.setRowHeight(30);
			modeloVentas.addColumn("Número");
			modeloVentas.addColumn("Fecha");
			modeloVentas.addColumn("Hora");
			modeloVentas.addColumn("Total");
		}
		
		//ordena los elementos de la ventana
		public void ordenaElementos(){
			panel2.setLayout(new BorderLayout(0, 20));
			panel2.add(panel21, BorderLayout.NORTH);
			panel2.add(panel22, BorderLayout.CENTER);
			panel2.add(panel23, BorderLayout.SOUTH);
			panel21.add(lblMes);
			panel21.add(cbxMes);
			panel21.add(lblAnio);
			panel21.add(txtAnio);
			panel21.add(label2);
			panel21.add(btnGenerarReporte);
			panel22.setLayout(new BorderLayout(0, 20));
			panel22.add(scrollVentas, BorderLayout.CENTER);	
			panel23.setLayout(new BorderLayout(3, 5));
			panel23.add(panel3, BorderLayout.NORTH);
			panel23.add(panel4, BorderLayout.SOUTH);
			panel3.setLayout(new GridLayout(1, 5, 0, 0));
			panel3.add(lblCantidad);
			panel3.add(txtCantidad);
			panel3.add(label1);
			panel3.add(lblTotal);
			panel3.add(txtTotal);
		}
		
		//deshabilita campos que no se deben editar, especificado en reglas de negocio	
		private void deshabilitaCampos(){
			btnGenerarReporte.setEnabled(true);
			txtTotal.setEditable(false);
			txtCantidad.setEditable(false);
		}
		
		//deja la ventana limpia
		private void limpiaCampos(){
			while(modeloVentas.getRowCount()>0)
				modeloVentas.removeRow(0);
			btnGenerarReporte.setEnabled(true);
			txtCantidad.setText("");
			txtTotal.setText("");
			txtAnio.setText("");
		}
		
		//genera el reporte de ventas
		//busca todas las ventas que coincidan con la fecha y calcula el total
		private void generarReporte(){
		}
		
		/*private void despliegaDatos(){
			datosVentas = servicioReporteMes.mostrarDatosLista();
			for(indice = 0; indice < datosVentas.size(); indice++)
				modeloVentas.addRow(new String [] {indice+1+"",datosVentas.get(indice)[0],datosVentas.get(indice)[1],datosVentas.get(indice)[2]});
		}
		
		
		//hace el calculo de las ventas desplegadas en pantalla
		private void calcularVentas(){
			ArrayList<String> ventasTotal = new ArrayList<String>();
			for(indice = 0; indice < tblVentas.getRowCount(); indice++){
				String v;
				v = modeloVentas.getValueAt(indice, 3)+"";
				ventasTotal.add(v);
			}
			if (servicioReporteMes.calcularVentas(ventasTotal)){
				txtCantidad.setText(tblVentas.getRowCount()+"");
				txtTotal.setText(servicioReporteMes.muestraTotal()+"");
			}
			else
				JOptionPane.showMessageDialog(ventana,"FallÃ³ operaciÃ³n al calcular el total.","Error",JOptionPane.ERROR_MESSAGE);
		}
		*/


}
