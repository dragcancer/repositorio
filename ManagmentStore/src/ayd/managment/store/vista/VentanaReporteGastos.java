package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

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

import ayd.managment.store.modelo.Gasto;
import ayd.managment.store.modelo.Venta;
import ayd.managment.store.servicio.Interface.ServicioReporteGastos;


public class VentanaReporteGastos extends VentanaGenerica{
	   //variables de clase
	    private ServicioReporteGastos servicioReporteGastos;
	   //botones
	    private JButton btnGenerarReporte = new JButton("Reporte");
    	private DefaultTableModel modeloVentas = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 
	//Etiquetas
	    private JLabel lblMes = new JLabel("Mes: ");
	    private JLabel lblAnio = new JLabel("Año: ");
	    private JLabel lblTotal = new JLabel("Total: $");
	    private JLabel label1 = new JLabel();
		private JLabel label2 = new JLabel();
		private JLabel label3 = new JLabel("");
		//Campos te texto
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

		public VentanaReporteGastos(ServicioReporteGastos control){
			super("Reporte de gastos","Regresar a ventana \"Generar reportes\"");
			servicioReporteGastos = control;
			colocaFormato();
			ordenaElementos();
			deshabilitaCampos();
			
			//busca todas las ventas realizadas en el dia y genera el reporte correspondiente
			btnGenerarReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//limpiaCampos();
					//servicioReporteGastos
					for(int i=modeloVentas.getRowCount()-1;i>=0;i--){
						modeloVentas.removeRow(i);
					}
					Gasto[] obgasto=servicioReporteGastos.ConsultaGasto(generarFechaIni(""+(cbxMes.getSelectedIndex()+1), txtAnio.getText()),generarFechaFin(""+(cbxMes.getSelectedIndex()+1), txtAnio.getText()));
					if(obgasto==null){
						JOptionPane.showMessageDialog(ventana, "no hay gastos en ese mes");
					}else{
						float total=0;
						for(int i=0;i<obgasto.length;i++){
							String[] aux= new String[4];
							aux[0]=obgasto[i].getNombre();
							aux[1]=obgasto[i].getFecha();
							aux[2]=obgasto[i].getDescripcion();
							aux[3]=""+obgasto[i].getAbono();
							total=total+obgasto[i].getAbono();
							modeloVentas.addRow(aux);
						}
						txtTotal.setText(""+total);
					}
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
			label3.setFont(new Font("Dialog", Font.BOLD, 28));
			label2.setFont(new Font("Dialog", Font.BOLD, 68));
			btnGenerarReporte.setFont(new Font("Dialog", Font.BOLD, 28));
			panel21.setBackground(UIManager.getColor("Button.focus"));
			panel22.setBackground(UIManager.getColor("Button.focus"));
			panel23.setBackground(UIManager.getColor("Button.focus"));
			panel3.setBackground(UIManager.getColor("Button.focus"));
			panel4.setBackground(UIManager.getColor("Button.focus"));
			label3.setFont(new Font("Dialog", Font.BOLD, 28));
     		lblTotal.setFont(new Font("Dialog", Font.BOLD, 28));
			txtTotal.setFont(new Font("Dialog", Font.BOLD, 28));
			tblVentas.setFont(new Font("Dialog", Font.BOLD, 28));
			tblVentas.setRowHeight(30);
			modeloVentas.addColumn("Nombre");
			modeloVentas.addColumn("Fecha");
			modeloVentas.addColumn("Descripción");
			modeloVentas.addColumn("Abono");
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
			panel3.add(label3);
			panel3.add(label1);
			panel3.add(lblTotal);
			panel3.add(txtTotal);
		}
		
		//deshabilita campos que no se deben editar, especificado en reglas de negocio	
		private void deshabilitaCampos(){
			btnGenerarReporte.setEnabled(true);
			txtTotal.setEditable(false);

		}
		
		//deja la ventana limpia
		private void limpiaCampos(){
			while(modeloVentas.getRowCount()>0)
				modeloVentas.removeRow(0);
			btnGenerarReporte.setEnabled(true);
			txtTotal.setText("");
			txtAnio.setText("");
		}
		
		//genera el reporte de ventas
		//busca todas las ventas que coincidan con la fecha y calcula el total
		private void generarReporte(){
		}
		
		private String generarFechaIni(String mes,String anio){
			//funcion para obtener l fecha del sistema
			if(Integer.parseInt(mes)<10){
				mes="0"+mes;
			}
			Date fecha = new Date();
			String Date;
			Date = String.format(anio+"-"+mes+"-"+"01"); 
			return Date;
		}
		
		private String generarFechaFin(String mes,String anio){
			//funcion para obtener l fecha del sistema
			Date fecha = new Date();
			String Date;
			int m=Integer.parseInt(mes);
			//1,3,5,7,8,10,12
			if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12 ){
				Date = String.format(anio+"-"+mes+"-"+"31"); 
			}else{
				if(m==4 || m==6 || m==9 || m==11){
					Date = String.format(anio+"-"+mes+"-"+"30"); 
				}else{
					Date = String.format(anio+"-"+mes+"-"+"28");
				}
			}
			return Date;
		}

}
