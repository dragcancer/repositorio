/*package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;



import ayd.managment.store.servicio.Interface.ServicioGenerarHoras;
import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;

//import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;

public class VentanaHoraEntrada extends VentanaGenerica {

	private ServicioGenerarHoraEntradaClase servicioGeneraHoraEntrada;
	private java.util.Calendar calendario;
	private int horas, minutos, segundos;
	private JButton btnRegistraHora = new JButton("Registra Hora");
	private DefaultTableModel modeloDiasLaborados = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 
	//Etiquetas
	private JLabel lblCodigoEmpleado = new JLabel("Ingrese el código del empleado:");
	private JLabel lblHora = new JLabel("Hora actual:");
	
	//Campos te texto
	private JTextField txtCodigoEmpleado = new JTextField("");
	private JTextField txtHoraActual = new JTextField("");
	
	private JPanel panel21 = new JPanel();
	private JPanel panel22 = new JPanel();
	private JPanel panel23 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private int tecla;
	private int punto = 0;
	private int limite = 0;
	
	
	public VentanaHoraEntrada(ServicioGenerarHoraEntradaClase servicioGenerarHoraEntradaClase){
		super("Hora de Entrada","Regresar a ventana \"Empleados\"");
		servicioGeneraHoraEntrada = servicioGenerarHoraEntradaClase;
		reloj();
		btnRegistraHora.setFont(new Font("Dialog", Font.BOLD, 30));
		panel21.setBackground(UIManager.getColor("Button.focus"));
		panel22.setBackground(UIManager.getColor("Button.focus"));
		panel23.setBackground(UIManager.getColor("Button.focus"));
		panel3.setBackground(UIManager.getColor("Button.focus"));
		panel4.setBackground(UIManager.getColor("Button.focus"));
		lblCodigoEmpleado.setFont(new Font("Dialog", Font.BOLD, 28));
		lblHora.setFont(new Font("Dialog", Font.BOLD, 28));
		txtCodigoEmpleado.setFont(new Font("Dialog", Font.BOLD, 28));
		txtHoraActual.setFont(new Font("Dialog", Font.BOLD, 28));
	
		modeloDiasLaborados.addColumn("Fecha");
		modeloDiasLaborados.addColumn("Hora de entrada");
		modeloDiasLaborados.addColumn("Hora de Salida");
		
		panel2.setLayout(new BorderLayout(0, 20));
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel22, BorderLayout.CENTER);
		panel2.add(panel23, BorderLayout.SOUTH);
		panel21.setLayout(new GridLayout(2, 1, 10, 10));
		panel21.add(panel3);
		panel21.add(panel4);
		panel3.setLayout(new GridLayout(3, 2, 10, 10));
		panel3.add(lblCodigoEmpleado);
		panel3.add(txtCodigoEmpleado);
		panel3.add(lblHora);
		panel3.add(txtHoraActual);
		panel4.add(btnRegistraHora);
		
		
		
		txtCodigoEmpleado.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaCadenaConEntero(txtCodigoEmpleado.getText(), e);
				activaBoton();
			}
		});
		
		txtHoraActual.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaEntero(txtHoraActual.getText(), e);
				activaBoton();
			}
		});
		
		txtCodigoEmpleado.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				activaBoton();
			}
		});
		
		txtHoraActual.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				activaBoton();
			}
		});
		
		
		btnRegistraHora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while(modeloDiasLaborados.getRowCount()>0)
					modeloDiasLaborados.removeRow(0);
				capturaHora();
				
				if(servicioGeneraHoraEntrada.entradaHorario(txtHoraActual.getText(),txtCodigoEmpleado.getText())){
					JOptionPane.showMessageDialog(ventana, "se registro hora");
				}else{
					JOptionPane.showMessageDialog(ventana, "El usuario ya se registro hoy o no existe");
				}
				
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
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
		if(txtCodigoEmpleado.getText().isEmpty() || txtHoraActual.getText().isEmpty())
			return false;
		else
			return true;
	}
	
	private void capturaHora(){
	}
	
	private void activaBoton(){
		if(camposNoVacios())
			btnRegistraHora.setEnabled(true);
		else
			btnRegistraHora.setEnabled(false);
	}
	
	private void limpiarCampos(){
		while(modeloDiasLaborados.getRowCount()>0)
			modeloDiasLaborados.removeRow(0);
		txtCodigoEmpleado.setText("");
		txtHoraActual.setText("");
		txtHoraActual.setEditable(false);
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
				txtHoraActual.setText(hour);
			}
		});
		timer.start();
	}

}*/
package ayd.managment.store.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Font;

import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;

public class VentanaHoraEntrada extends JFrame {

	private JPanel contentPane;
	private JTextField empleado;
	private JTextField HraEntrada;
	private JLabel lblHoraEntrada;
	private JLabel lblEmpleado;
	private JPanel panel_1;
	private JButton Registrar;
	private JPanel panel;
	private GregorianCalendar calendario;
	private int segundos;
	private JFrame ventana=this;
	private int tecla;
	private ServicioGenerarHoraEntradaClase servicioGeneraHoraEntrada;
public VentanaHoraEntrada(ServicioGenerarHoraEntradaClase servicioGenerarHoraEntradaClase) {
	servicioGeneraHoraEntrada = servicioGenerarHoraEntradaClase;
	reloj();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1302, 664);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	SpringLayout sl_contentPane = new SpringLayout();
	contentPane.setLayout(sl_contentPane);
	
	panel = new JPanel();
	sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 604, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, panel, 247, SpringLayout.WEST, contentPane);
	panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
	contentPane.add(panel);
	panel.setLayout(null);
	
	 Registrar = new JButton("");
	Registrar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Actions-dialog-ok-apply-icon.png"));
	Registrar.setToolTipText("Realizar registro de hora");
	Registrar.setBounds(10, 11, 216, 170);
	panel.add(Registrar);
	
	JButton Buscar = new JButton("");
	Buscar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\search-icon.png"));
	Buscar.setToolTipText("Buscar empleado");
	Buscar.setBounds(10, 207, 216, 176);
	panel.add(Buscar);
	
	JButton button = new JButton("");
	button.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Actions-edit-delete-icon.png"));
	button.setToolTipText("Buscar empleado");
	button.setBounds(10, 413, 216, 159);
	panel.add(button);
	
	panel_1 = new JPanel();
	sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 94, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 273, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 516, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 1226, SpringLayout.WEST, contentPane);
	panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
    lblEmpleado = new JLabel("Empleado:");
	lblEmpleado.setFont(new Font("Dialog", Font.PLAIN, 18));
	lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmpleado.setBounds(69, 144, 111, 24);
	panel_1.add(lblEmpleado);
	
	 lblHoraEntrada = new JLabel("Hora Entrada:");
	lblHoraEntrada.setFont(new Font("Dialog", Font.PLAIN, 18));
	lblHoraEntrada.setHorizontalAlignment(SwingConstants.CENTER);
	lblHoraEntrada.setBounds(69, 239, 143, 14);
	panel_1.add(lblHoraEntrada);
	
	empleado = new JTextField();
	empleado.setFont(new Font("Dialog", Font.PLAIN, 18));
	empleado.setBounds(235, 132, 642, 44);
	panel_1.add(empleado);
	empleado.setColumns(10);
	
	HraEntrada = new JTextField();
	HraEntrada.setFont(new Font("Dialog", Font.PLAIN, 18));
	HraEntrada.setColumns(10);
	HraEntrada.setBounds(235, 224, 642, 44);
	panel_1.add(HraEntrada);
	
	empleado.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			validaCadenaConEntero(empleado.getText(), e);
			activaBoton();
		}
	});
	
	HraEntrada.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			validaEntero(HraEntrada.getText(), e);
			activaBoton();
		}
	});
	
	empleado.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			activaBoton();
		}
	});
	
	HraEntrada.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			activaBoton();
		}
	});
	
	
	Registrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			if(servicioGeneraHoraEntrada.entradaHorario(HraEntrada.getText(),empleado.getText())){
				JOptionPane.showMessageDialog(ventana, "se registro hora");
			}else{
				JOptionPane.showMessageDialog(ventana, "El usuario ya se registro hoy o no existe");
			}
			
		}
	});
	
	button.addActionListener(new ActionListener() {
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
	if(empleado.getText().isEmpty() || HraEntrada.getText().isEmpty())
		return false;
	else
		return true;
}


private void activaBoton(){
	if(camposNoVacios())
		Registrar.setEnabled(true);
	else
		Registrar.setEnabled(false);
}

private void limpiarCampos(){
	empleado.setText("");
	HraEntrada.setText("");
	HraEntrada.setEditable(false);
}


private void reloj(){
	calendario = new java.util.GregorianCalendar();
	segundos = calendario.get(Calendar.SECOND);
	javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
		private int horas;
		private int minutos;

		@ Override
		public void actionPerformed(java.awt.event.ActionEvent ae) {
			java.util.Date actual = new java.util.Date();
			calendario.setTime(actual);
			horas = calendario.get(Calendar.HOUR_OF_DAY);
			minutos = calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND);
			String hour = String.format(""+"%02d:%02d:%02d",horas,minutos,segundos);
			HraEntrada.setText(hour);
		}
	});
	timer.start();
}
	

}

