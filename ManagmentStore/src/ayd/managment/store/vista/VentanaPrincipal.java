package ayd.managment.store.vista;
import ayd.managment.store.principal.Aplicacion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//Heredo de VentanaGenerica
@SuppressWarnings("serial")
public class VentanaPrincipal extends VentanaGenerica{

	//Declaracion de variables
	private Aplicacion app;
	private Date hora = new Date();
	GridBagConstraints gbc = new GridBagConstraints();
	
	public VentanaPrincipal(Aplicacion control){
		super("	Management Store","Cerrar sistema");
		app = control;
		
		panel2.setLayout(new GridBagLayout());
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.productos();
        	}
        });

		btnProductos.setFont(new Font("Dialog", Font.BOLD, 30));
		btnProductos.doLayout();

		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnProductos, gbc);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.usuarios();
			}
		});

		btnEmpleados.setFont(new Font("Dialog", Font.BOLD, 30));
		btnEmpleados.doLayout();
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnEmpleados, gbc);


		JButton btnVentas = new JButton("Ventas");
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.ventas();
			}
		});

		btnVentas.setFont(new Font("Dialog", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnVentas, gbc);

		JButton btnGenerarPedido = new JButton("Generar pedido");
		btnGenerarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.generarPedido();
			}
		});
		
		
		btnGenerarPedido.setFont(new Font("Dialog", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnGenerarPedido, gbc);

		
		
		JButton btnHoras = new JButton("Registros");
		btnHoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     //app.generarPedido();	
				app.registrarHoras();
			}
		});
		
		
		btnHoras.setFont(new Font("Dialog", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnHoras, gbc);

		JButton btnProveedores = new JButton("Proveedores");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.proveedores();
			}
		});
		
		
		btnProveedores.setFont(new Font("Dialog", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnProveedores, gbc);
		
		
		
		
		JButton btnConsultaRapida = new JButton("Consulta rápida");
		btnConsultaRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.consultaRapida();
			}
		});

		btnConsultaRapida.setFont(new Font("Dialog", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnConsultaRapida, gbc);
		
		JButton btnGenerarReportes = new JButton("Generar reportes");
		btnGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.reportes();            
			}
		});

		btnGenerarReportes.setFont(new Font("Dialog", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 0, 30);
		gbc.gridx = 4;
		gbc.gridy = 12;
		gbc.gridwidth = 3;
		gbc.gridheight = 3;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnGenerarReportes, gbc);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		//panel3.setLayout(new BorderLayout(0, 0));
		//panel3.add(btnSalir, BorderLayout.EAST);
		@SuppressWarnings("deprecation")
		String inicio = String.format("Inicio de sistema: "+"%02d:%02d:%02d",hora.getHours(),hora.getMinutes(),hora.getSeconds());
		JLabel lblHoraInicio = new JLabel(inicio);
		lblHoraInicio.setForeground(Color.WHITE);
		lblHoraInicio.setFont(new Font("Dialog", Font.BOLD, 20));
		panel3.add(lblHoraInicio, BorderLayout.WEST);
	}
}
