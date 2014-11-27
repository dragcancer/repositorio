package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import ayd.managment.store.servicio.clase.ServicioGenerarHoraEntradaClase;
import ayd.managment.store.servicio.clase.ServicioGenerarHoraSalidaClase;









public class VentanaHoraSalida extends VentanaGenerica {
	private ServicioGenerarHoraSalidaClase servicioGeneraHoraSalida;
	private java.util.Calendar calendario;
	private int horas, minutos, segundos;
	private JButton btnRegistraHora = new JButton("Registra Hora Salida");
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
	
	
	public VentanaHoraSalida(ServicioGenerarHoraSalidaClase servicioGenerarEntrada){
		super("Hora de Salida","Regresar a ventana \"Empleados\"");
		servicioGeneraHoraSalida = servicioGenerarEntrada;
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
				
				servicioGeneraHoraSalida.salidaHorario(txtHoraActual.getText(),txtCodigoEmpleado.getText());
				
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



}
