package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class VentanaGenerica extends JFrame {
	
	//Declaracion de variables
	private JPanel contentPane = new JPanel();
	public JFrame ventana = this;
	private JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	private JLabel lblTitulo = new JLabel();
	private JLabel lblHoraActual = new JLabel();
	public JButton btnSalir = new JButton();
	private java.util.Calendar calendario;
	private int horas, minutos, segundos;
	
	public VentanaGenerica(String titulo, String textoBtnSalir) {
		this.setTitle(titulo);
		//formato a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel1.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		contentPane.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblTitulo.setText(titulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 44));
		lblTitulo.setForeground(new Color(255, 255, 255));
		panel1.add(lblTitulo);
		
		panel2.setBackground(UIManager.getColor("Button.focus"));
		contentPane.add(panel2, BorderLayout.CENTER);
		
		panel3.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		contentPane.add(panel3, BorderLayout.SOUTH);
		
		btnSalir.setText(textoBtnSalir);
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 30));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.dispose();
			}
		});
		panel3.setLayout(new BorderLayout(0, 0));
		panel3.add(btnSalir, BorderLayout.EAST);
		lblHoraActual.setForeground(Color.WHITE);
		lblHoraActual.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHoraActual.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(lblHoraActual, BorderLayout.CENTER);
		reloj();
		//ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);	
		//ventana.setUndecorated(true);
		//ventana.setAlwaysOnTop(true);
	}
	
	//Proceso para colocar la hora en la pantalla
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
				String hour = String.format("Hora actual: "+"%02d:%02d:%02d",horas,minutos,segundos);
				lblHoraActual.setText(" " + hour + " ");
			}
		});
		timer.start();
	}
}