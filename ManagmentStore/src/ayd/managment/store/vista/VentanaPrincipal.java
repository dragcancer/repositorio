package ayd.managment.store.vista;


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
import javax.swing.JScrollPane;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Aplicacion app;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal(Aplicacion control) {
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
		button.setToolTipText("Modo Administrador");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.ventanaAdmin();
			}
		});
		button.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Caucasian-Boss-icon.png"));
		button.setBounds(21, 22, 457, 160);
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setToolTipText("Salir");
		button_1.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Log-Out-icon.png"));
		button_1.setBounds(21, 201, 457, 160);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(27, 67, 691, 534);
		contentPane.add(panel_2);
		
		JButton btnConsutaRapida = new JButton("");
		btnConsutaRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.consultaRapida();
			}
		});
		btnConsutaRapida.setToolTipText("Consulta R\u00E1pida");
		btnConsutaRapida.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Apps-accessories-dictionary-icon.png"));
		btnConsutaRapida.setBounds(22, 72, 310, 190);
		panel_2.add(btnConsutaRapida);
		
		JButton buttonGenerarPedido = new JButton("");
		buttonGenerarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.generarPedido();
			}
		});
		buttonGenerarPedido.setToolTipText("Generar Pedido");
		buttonGenerarPedido.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Apps-basket-icon.png"));
		buttonGenerarPedido.setBounds(22, 274, 310, 190);
		panel_2.add(buttonGenerarPedido);
		
		JButton btnVenta = new JButton("");
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.ventas();
			}
		});
		btnVenta.setToolTipText("Venta");
		btnVenta.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\shop-cart-icon.png"));
		btnVenta.setBounds(342, 274, 310, 187);
		panel_2.add(btnVenta);
		
		JButton btnRegistroHoras = new JButton("");
		btnRegistroHoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.registrarHoras();
			}
		});
		btnRegistroHoras.setToolTipText("Registro de Horas");
		btnRegistroHoras.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\clock-icon.png"));
		btnRegistroHoras.setBounds(342, 72, 310, 190);
		panel_2.add(btnRegistroHoras);
	}
}
