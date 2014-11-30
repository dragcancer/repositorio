package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class VentanaReporteMes extends JFrame {

	private JPanel contentPane;
	private JTable tblVentas;
	private DefaultTableModel modeloVentas = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	};
	private JScrollPane scrollVentas;
	private JTextField txtAnio;
	private JTextField txtCantidad;
	private JTextField txtTotal;
	private JComboBox cbxMesa; 
	private ayd.managment.store.servicio.Interface.ServicioReporteMes servicioReporteMes;
	private ArrayList<String[]> datosVentas = new ArrayList<String[]>();
	private int indice;
	public JFrame ventana = this;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReporteMes frame = new VentanaReporteMes();
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
	public VentanaReporteMes(ayd.managment.store.servicio.Interface.ServicioReporteMes control) {
		servicioReporteMes = control;
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
		
		JButton btnGenerarReporte = new JButton("");
		btnGenerarReporte.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\custom-reports-icon.png"));
		btnGenerarReporte.setToolTipText("Generar Reporte");
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayd.managment.store.modelo.Venta[] ventas=servicioReporteMes.generarReporte(""+(cbxMesa.getSelectedIndex()+1), txtAnio.getText());
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
		btnGenerarReporte.setBounds(10, 101, 171, 170);
		panelBotones.add(btnGenerarReporte);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Actions-go-previous-icon.png"));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
			}
		});
		btnRegresar.setBounds(10, 282, 171, 170);
		panelBotones.add(btnRegresar);
		
		JPanel panelCodigo = new JPanel();
		panelCodigo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCodigo.setBounds(215, 11, 1041, 81);
		panelMarco.add(panelCodigo);
		panelCodigo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(69, 34, 64, 27);
		panelCodigo.add(lblNewLabel);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(794, 32, 192, 29);
		panelCodigo.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAo.setBounds(726, 32, 137, 27);
		panelCodigo.add(lblAo);
		
		cbxMesa = new JComboBox();
		cbxMesa.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cbxMesa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxMesa.setBounds(129, 40, 185, 20);
		panelCodigo.add(cbxMesa);
		modeloVentas.addColumn("Número");
		modeloVentas.addColumn("Fecha");
		modeloVentas.addColumn("Hora");
		modeloVentas.addColumn("Total");
		tblVentas= new JTable(modeloVentas);
		tblVentas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollVentas=new JScrollPane (tblVentas);
		scrollVentas.setBounds(215, 118, 1041, 357);
		panelMarco.add(scrollVentas);
		
		scrollVentas.setPreferredSize(new Dimension(400,150));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(215, 486, 1041, 96);
		panelMarco.add(panel);
		panel.setLayout(null);
		
		JLabel txtC = new JLabel("Total de venta:");
		txtC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtC.setBounds(10, 40, 198, 14);
		panel.add(txtC);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCantidad.setBounds(167, 35, 216, 30);
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTotal.setColumns(10);
		txtTotal.setBounds(677, 35, 237, 31);
		panel.add(txtTotal);
		
		JLabel lblTotal = new JLabel("Total: $");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotal.setBounds(582, 37, 198, 14);
		panel.add(lblTotal);
		
	}
	public void set_Table(){
	}
}
