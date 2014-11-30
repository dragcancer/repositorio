package ayd.managment.store.vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;

import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;

import ayd.managment.store.servicio.Interface.ServicioVentaTotal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class VentanaVentaTotal extends JFrame {

	private JPanel contentPane;
	private JTable tblVentas;
	private DefaultTableModel modeloVentas = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 
	//private String[][] datos={{"Fernando","01213","0"," d","d","c"}};
	//private String[] cabecera={"Número","Fecha","Hora","Total"};
	private JScrollPane sblVentas;
	private JTextField txtCantidad;
	private ServicioVentaTotal servicioVentaTotal;
	private JFrame ventana = this;
	
	private ArrayList<String[]> datosVentas = new ArrayList<String[]>();
	private int indice;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentaTotal frame = new VentanaVentaTotal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaVentaTotal(ServicioVentaTotal control) {
		servicioVentaTotal = control;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		set_Table();
		JPanel panelMarco = new JPanel();
		panelMarco.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMarco.setBounds(10, 22, 1266, 593);
		contentPane.add(panelMarco);
		panelMarco.setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBotones.setBounds(10, 11, 195, 571);
		panelMarco.add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton btnGeneraReporte = new JButton("");
		btnGeneraReporte.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\custom-reports-icon.png"));
		btnGeneraReporte.setToolTipText("Generar Reporte");
		btnGeneraReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarReporte();
			}		
		});
		btnGeneraReporte.setBounds(10, 11, 171, 149);
		panelBotones.add(btnGeneraReporte);
		
		JButton btnGuardarHistorial = new JButton("");
		btnGuardarHistorial.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Actions-mail-receive-icon.png"));
		btnGuardarHistorial.setToolTipText("Guardar en historial");
		btnGuardarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(servicioVentaTotal.guardaEnHistorial()){
					JOptionPane.showMessageDialog(ventana,"Operación exitosa al guardar en historial.");				
					//btnGenerarReporte.setEnabled(false);
					//btnGuardarEnHistorial.setEnabled(false);
				}
				else
					JOptionPane.showMessageDialog(ventana,"Fallo operación al guardar en historial, ya se ha cargado la venta al historial anteriormente.","Error",JOptionPane.ERROR_MESSAGE);
			}
				
			
		});
		btnGuardarHistorial.setBounds(10, 191, 171, 149);
		panelBotones.add(btnGuardarHistorial);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Actions-go-previous-icon.png"));
		btnSalir.setToolTipText("Regrear");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnSalir.setBounds(10, 371, 171, 149);
		panelBotones.add(btnSalir);
		
		JPanel panelCodigo = new JPanel();
		panelCodigo.setBounds(215, 480, 1041, 81);
		panelMarco.add(panelCodigo);
		panelCodigo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 30, 137, 27);
		panelCodigo.add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(93, 32, 167, 29);
		panelCodigo.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total: $");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotal.setBounds(704, 30, 88, 27);
		panelCodigo.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(802, 30, 206, 29);
		panelCodigo.add(txtTotal);
		modeloVentas.addColumn("Número");
		modeloVentas.addColumn("Fecha");
		modeloVentas.addColumn("Hora");
		modeloVentas.addColumn("Total");
		tblVentas= new JTable(modeloVentas);
		sblVentas=new JScrollPane (tblVentas);
		sblVentas.setBounds(215, 11, 1041, 458);
		panelMarco.add(sblVentas);
		
		sblVentas.setPreferredSize(new Dimension(400,150));
		

	}

	//deshabilita campos que no se deben editar, especificado en reglas de negocio	
	private void deshabilitaCampos(){
		txtTotal.setEditable(false);
		txtCantidad.setEditable(false);
	}
	
	

		//genera el reporte de ventas
		//busca todas las ventas que coincidan con la fecha y calcula el total
	    private void generarReporte(){
	    	if(servicioVentaTotal.buscarVentas()){
	    		//btnGuardarHistorial.setEnabled(false);
	    		despliegaDatos();
	    		calcularVentas();
	    		//btnGuardarHistorial.setEnabled(true);
	    		}else
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
	    		}else
	    			JOptionPane.showMessageDialog(ventana,"Fallo operación al calcular el total.","Error",JOptionPane.ERROR_MESSAGE);
		}
	    
		//deja la ventana limpia
		private void limpiaCampos(){
			while(modeloVentas.getRowCount()>0)
				modeloVentas.removeRow(0);
			//btnGuardarEnHistorial.setEnabled(false);
			//btnGenerarReporte.setEnabled(true);
			txtCantidad.setText("");
			txtTotal.setText("");
		}

		// TODO Auto-generated method stub
		




	public void set_Table(){
	}
	
	
}
