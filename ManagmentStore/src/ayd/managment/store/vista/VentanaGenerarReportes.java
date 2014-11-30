package ayd.managment.store.vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import ayd.managment.store.principal.Aplicacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaGenerarReportes extends JFrame {

	private JPanel contentPane;
	private Aplicacion app;
	private JFrame ventana = this;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGenerarReportes frame = new VentanaGenerarReportes();
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
	public VentanaGenerarReportes(Aplicacion control) {
		app=control;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(22, 39, 691, 534);
		contentPane.add(panel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.reportesVentasDia();
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\event-icon.png"));
		button.setToolTipText("Generar Reporte por d\u00EDa");
		button.setBounds(22, 72, 311, 412);
		panel.add(button);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.reporteMes();
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Calendar-icon.png"));
		button_4.setToolTipText("Reporte de Venta por mes");
		button_4.setBounds(343, 72, 315, 412);
		panel.add(button_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(740, 358, 524, 214);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnNewButton.setToolTipText("Regresar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Azhala\\git\\repositorio\\ManagmentStore\\Iconos\\Actions-go-previous-icon.png"));
		btnNewButton.setBounds(40, 39, 450, 138);
		panel_1.add(btnNewButton);
	}

}
