package ayd.managment.store.vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ayd.managment.store.principal.Aplicacion;

public class VentanaProveedores extends VentanaGenerica {
	private Aplicacion app;

	public VentanaProveedores(Aplicacion control){
		super("Proveedores","Regresar a ventana \"Principal\"");
		app = control;
		
		//Asigno un Layaout para organizar los elementos en la ventana
		panel2.setLayout(new GridBagLayout());
				
		//Creo botones y los coloco segun mi conveniencia con el Layaout seleccionado
		JButton btnAlta = new JButton("Alta de proveedor");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.altaProveedores();
			}
		});
		btnAlta.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 0, 30);
		gbc_btnAlta.gridx = 0; 
		gbc_btnAlta.gridy = 0;
		gbc_btnAlta.gridwidth = 3;
		gbc_btnAlta.gridheight = 3;
		gbc_btnAlta.weighty = 1.0;
		gbc_btnAlta.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnAlta, gbc_btnAlta);
		
		JButton btnBaja = new JButton("Baja de proveedor");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.bajaProveedores();
			}
		});
		btnBaja.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 0, 30);
		gbc_btnBaja.gridx = 4; 
		gbc_btnBaja.gridy = 0;
		gbc_btnBaja.gridwidth = 3;
		gbc_btnBaja.gridheight = 3;
		gbc_btnBaja.weighty = 1.0;
		gbc_btnBaja.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnBaja, gbc_btnBaja);

		
		
		
		JButton btnConsulta = new JButton("Consulta de proveedor");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.consultaProveedores();
			}
		});
		btnConsulta.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnConsulta = new GridBagConstraints();
		gbc_btnConsulta.insets = new Insets(0, 0, 0, 30);
		gbc_btnConsulta.gridx = 0; 
		gbc_btnConsulta.gridy = 4;
		gbc_btnConsulta.gridwidth = 3;
		gbc_btnConsulta.gridheight = 3;
		gbc_btnConsulta.weighty = 1.0;
		gbc_btnConsulta.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnConsulta, gbc_btnConsulta);
		
		JButton btnModifica = new JButton("Modifica proveedor");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.actualizaProveedores();
			}
		});
		btnModifica.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnActualizacion = new GridBagConstraints();
		gbc_btnActualizacion.insets = new Insets(0, 0, 0, 30);
		gbc_btnActualizacion.gridx = 4; 
		gbc_btnActualizacion.gridy = 4;
		gbc_btnActualizacion.gridwidth = 3;
		gbc_btnActualizacion.gridheight = 3;
		gbc_btnActualizacion.weighty = 1.0;
		gbc_btnActualizacion.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnModifica, gbc_btnActualizacion);

	}


}
