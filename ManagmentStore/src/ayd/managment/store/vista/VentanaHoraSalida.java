package ayd.managment.store.vista;


import ayd.managment.store.servicio.clase.ServicioGenerarHoraSalidaClase;


import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;


public class VentanaHoraSalida extends JFrame {
	private ServicioGenerarHoraSalidaClase servicioGeneraHoraSalida;
	private java.util.Calendar calendario;
	private int horas, minutos, segundos;
	private JPanel contentPane;
	private JTextField Empleado;
	private JTextField hraSalida;
	private JButton Registrar;
	private int tecla;
	private Object modeloDiasLaborados;
	private JButton Buscar;

	/**
	 * Create the frame.
	 */
	public VentanaHoraSalida(ServicioGenerarHoraSalidaClase servicioGenerarEntrada) {
		servicioGeneraHoraSalida=servicioGenerarEntrada;
		reloj();
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaHoraSalida.class.getResource("/iconos/Apps-clock-icon.png")));
		setTitle("Hora Salida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 604, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 247, SpringLayout.WEST, contentPane);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//..\\ManagmentStore\\Iconos\\Caucasian-Boss-icon.png
		 Registrar = new JButton("");
		 Registrar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Actions-dialog-ok-apply-icon.png"));
		//Registrar.setIcon(new ImageIcon(VentanaHoraEntrada.class.getResource("/iconos/Actions-dialog-ok-apply-icon.png")));
		Registrar.setToolTipText("Realizar registro de hora");
		Registrar.setBounds(10, 11, 216, 170);
		panel.add(Registrar);
		
		 Buscar = new JButton("");
		 Buscar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\search-icon.png"));
		Buscar.setToolTipText("Buscar empleado");
		Buscar.setBounds(10, 207, 216, 176);
		panel.add(Buscar);
		
		JButton salir = new JButton("");
		salir.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Actions-edit-delete-icon.png"));
		salir.setToolTipText("Salir ");
		salir.setBounds(10, 413, 216, 159);
		panel.add(salir);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 94, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 273, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 516, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 1226, SpringLayout.WEST, contentPane);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setBounds(69, 144, 111, 24);
		panel_1.add(lblEmpleado);
		
		JLabel lblHorasalida = new JLabel("Hora Salida");
		lblHorasalida.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblHorasalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorasalida.setBounds(69, 239, 143, 14);
		panel_1.add(lblHorasalida);
		
		Empleado = new JTextField();
		Empleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validaCadenaConEntero(hraSalida.getText(), e);
				activaBoton();
			}
		});
		
			
		Empleado.setFont(new Font("Dialog", Font.PLAIN, 18));
		Empleado.setBounds(235, 132, 642, 44);
		panel_1.add(Empleado);
		Empleado.setColumns(10);
		
		hraSalida = new JTextField();
		hraSalida.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validaEntero(hraSalida.getText(), e);
				activaBoton();
			}
		});
		hraSalida.setFont(new Font("Dialog", Font.PLAIN, 18));
		hraSalida.setColumns(10);
		hraSalida.setBounds(235, 224, 642, 44);
		panel_1.add(hraSalida);
		Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		hraSalida.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				activaBoton();
			}
		});
	
	
	Registrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			servicioGeneraHoraSalida.salidaHorario(hraSalida.getText(),Empleado.getText());
		}
	});
	
	salir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			limpiarCampos();
		}
	});
}
	private void  validaCadenaConEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
    	if(tecla >= 32 && tecla <= 47 || tecla >=58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
    		e.consume();
    }
	
	private void  validaEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 32 && tecla <= 47 || tecla >= 58 && tecla <= 255)
			e.consume();
	}
	 
	private boolean camposNoVacios(){
		if(Empleado.getText().isEmpty() || hraSalida.getText().isEmpty())
			return false;
		else
			return true;
	}
	
	private void capturaHora(){
	}
	
	private void activaBoton(){
		if(camposNoVacios())
			Registrar.setEnabled(true);
		else
			Registrar.setEnabled(false);
	}
	
	private void limpiarCampos(){
		
		Empleado.setText("");
		hraSalida.setText("");
		hraSalida.setEditable(false);
	}
	
	
	private void reloj(){
		calendario = new java.util.GregorianCalendar();
		segundos = calendario.get(Calendar.SECOND);
		javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
			@ Override
			public void actionPerformed(java.awt.event.ActionEvent ae) {
				java.util.Date actual = new java.util.Date();
				calendario.setTime(actual);
				horas = calendario.get(Calendar.HOUR_OF_DAY);
				minutos = calendario.get(Calendar.MINUTE);
				segundos = calendario.get(Calendar.SECOND);
				String hour = String.format(""+"%02d:%02d:%02d",horas,minutos,segundos);
				hraSalida.setText(hour);
			}
		});
		timer.start();
	}
}
