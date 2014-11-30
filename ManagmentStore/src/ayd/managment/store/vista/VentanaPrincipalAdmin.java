package ayd.managment.store.vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import ayd.managment.store.principal.Aplicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipalAdmin extends JFrame {

	private JPanel contentPane;
	private Aplicacion app;
	public JFrame ventana = this;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalAdmin frame = new VentanaPrincipalAdmin();
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
	public VentanaPrincipalAdmin(Aplicacion control) {
		app=control;
		setTitle("Management Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(751, 67, 505, 120);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Management Store");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(10, 11, 485, 98);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(752, 212, 504, 385);
		contentPane.add(panel_1);
		
		JButton button = new JButton("");
		button.setToolTipText("Modo Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.ventanaPrincipal();
				ventana.dispose();
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\user-icon.png"));
		button.setBounds(21, 22, 457, 160);
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setToolTipText("Salir");
		button_1.setIcon(new ImageIcon("C:\\Users\\Azhala\\workspace\\Ventanas\\Iconos\\Log-Out-icon.png"));
		button_1.setBounds(21, 201, 457, 160);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(27, 67, 691, 534);
		contentPane.add(panel_2);
		
		JButton bntEmpleados = new JButton("");
		bntEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.usuarios();
			}
		});
		bntEmpleados.setToolTipText("Empleados");
		bntEmpleados.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Apps-system-users-icon (1).png"));
		bntEmpleados.setBounds(22, 72, 203, 190);
		panel_2.add(bntEmpleados);
		
		JButton btnReportes = new JButton("");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.reportes();
			}
		});
		btnReportes.setToolTipText("Reportes");
		btnReportes.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Actions-mail-mark-task-icon.png"));
		btnReportes.setBounds(22, 274, 310, 190);
		panel_2.add(btnReportes);
		
		JButton bntGastos = new JButton("");
		bntGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.gastos();
			}
		});
		bntGastos.setToolTipText("Gastos");
		bntGastos.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Apps-kwalletmanager-icon.png"));
		bntGastos.setBounds(342, 274, 310, 187);
		panel_2.add(bntGastos);
		
		JButton btnProveedores = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.proveedores();
			}
		});
		btnProveedores.setToolTipText("Proveedores");
		btnProveedores.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\truck-icon.png"));
		btnProveedores.setBounds(235, 72, 204, 190);
		panel_2.add(btnProveedores);
		
		JButton btnProductos = new JButton("");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.productos();
			}
		});
		btnProductos.setToolTipText("Productos");
		btnProductos.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\basket-icon.png"));
		btnProductos.setBounds(449, 72, 203, 190);
		panel_2.add(btnProductos);
	}

}
