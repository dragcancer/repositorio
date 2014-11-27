package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import ayd.managment.store.servicio.Interface.ServicioVentaTotal;

//Heredo de VentanaGenerica
public class VentanaVentaTotal extends VentanaGenerica{
	//variables de clase
	private ServicioVentaTotal servicioVentaTotal;
	//botones
	private JButton btnGenerarReporte = new JButton("Generar reporte");
	private JButton btnGuardarEnHistorial = new JButton("Guardar en historial");
	private DefaultTableModel modeloVentas = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 
	//Etiquetas
	private JLabel lblCantidad = new JLabel("Total de ventas: ");
	private JLabel lblTotal = new JLabel("Total: $");
	private JLabel label1 = new JLabel();
	//Campos te texto
	private JTextField txtCantidad = new JTextField("");
	private JTextField txtTotal = new JTextField("");
	
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

	public VentanaVentaTotal(ServicioVentaTotal control){
		super("Venta total","Regresar a ventana \"Generar reportes\"");
		servicioVentaTotal = control;
		colocaFormato();
		ordenaElementos();
		deshabilitaCampos();
		
		//busca todas las ventas realizadas en el dia y genera el reporte correspondiente
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarReporte();
			}
		});
		
		//una vez generado el reporte
		//guarda el total con la fecha en historial
		btnGuardarEnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(servicioVentaTotal.guardaEnHistorial()){
					JOptionPane.showMessageDialog(ventana,"Operación exitosa al guardar en historial.");				
					btnGenerarReporte.setEnabled(false);
					btnGuardarEnHistorial.setEnabled(false);
				}
				else
					JOptionPane.showMessageDialog(ventana,"Falló operación al guardar en historial, ya se ha cargado la venta al historial anteriormente.","Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		
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
		btnGenerarReporte.setFont(new Font("Dialog", Font.BOLD, 30));
		btnGuardarEnHistorial.setFont(new Font("Dialog", Font.BOLD, 30));
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
		modeloVentas.addColumn("N�mero");
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
		panel21.add(btnGenerarReporte);
		panel22.setLayout(new BorderLayout(0, 20));
		panel22.add(scrollVentas, BorderLayout.CENTER);	
		panel23.setLayout(new BorderLayout(3, 5));
		panel23.add(panel3, BorderLayout.NORTH);
		panel23.add(panel4, BorderLayout.SOUTH);
		panel4.add(btnGuardarEnHistorial, BorderLayout.SOUTH);
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
		btnGuardarEnHistorial.setEnabled(false);
		txtTotal.setEditable(false);
		txtCantidad.setEditable(false);
	}
	
	//deja la ventana limpia
	private void limpiaCampos(){
		while(modeloVentas.getRowCount()>0)
			modeloVentas.removeRow(0);
		btnGuardarEnHistorial.setEnabled(false);
		btnGenerarReporte.setEnabled(true);
		txtCantidad.setText("");
		txtTotal.setText("");
	}
	
	//genera el reporte de ventas
	//busca todas las ventas que coincidan con la fecha y calcula el total
	private void generarReporte(){
		if(servicioVentaTotal.buscarVentas()){
			btnGenerarReporte.setEnabled(false);
			despliegaDatos();
			calcularVentas();
			btnGuardarEnHistorial.setEnabled(true);
		}
		else
			JOptionPane.showMessageDialog(ventana,"No se han realizado ventas este día.","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void despliegaDatos(){
		datosVentas = servicioVentaTotal.mostrarDatosLista();
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
		if (servicioVentaTotal.calcularVentas(ventasTotal)){
			txtCantidad.setText(tblVentas.getRowCount()+"");
			txtTotal.setText(servicioVentaTotal.muestraTotal()+"");
		}
		else
			JOptionPane.showMessageDialog(ventana,"Falló operación al calcular el total.","Error",JOptionPane.ERROR_MESSAGE);
	}
}
