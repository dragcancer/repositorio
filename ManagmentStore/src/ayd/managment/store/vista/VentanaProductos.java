package ayd.managment.store.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import ayd.managment.store.principal.Aplicacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Heredo de VentanaGenerica
public class VentanaProductos extends VentanaGenerica{
	
	private Aplicacion app;
	
	public VentanaProductos(Aplicacion control) {
		super("Productos","Regresar a ventana \"Principal\"");
		app = control;
		
		//Asigno un Layaout para organizar los elementos en la ventana
		panel2.setLayout(new GridBagLayout());
		
		//Creo botones y los coloco segun mi conveniencia con el Layaout seleccionado
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.altaProductos();
			}
		});
		btnAlta.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 0, 30);
		gbc_btnAlta.gridx = 0; 
		gbc_btnAlta.gridy = 0;
		gbc_btnAlta.gridwidth = 4;
		gbc_btnAlta.gridheight = 4;
		gbc_btnAlta.weighty = 1.0;
		gbc_btnAlta.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnAlta, gbc_btnAlta);

		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.bajaProductos();
			}
		});
		btnBaja.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 0, 30);
		gbc_btnBaja.gridx = 4; 
		gbc_btnBaja.gridy = 0;
		gbc_btnBaja.gridwidth = 4;
		gbc_btnBaja.gridheight = 4;
		gbc_btnBaja.weighty = 1.0;
		gbc_btnBaja.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnBaja, gbc_btnBaja);
		
		JButton btnActualizacion = new JButton("Actualización");
		btnActualizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.actualizacionProductos();
			}
		});
		btnActualizacion.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnActualizacion = new GridBagConstraints();
		gbc_btnActualizacion.insets = new Insets(0, 0, 0, 30);
		gbc_btnActualizacion.gridx = 0; 
		gbc_btnActualizacion.gridy = 4;
		gbc_btnActualizacion.gridwidth = 4;
		gbc_btnActualizacion.gridheight = 4;
		gbc_btnActualizacion.weighty = 1.0;
		gbc_btnActualizacion.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnActualizacion, gbc_btnActualizacion);
		
		JButton btnActualizacionLotes = new JButton("Actualización por lotes");
		btnActualizacionLotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.actualizacionPorLotes();
			}
		});
		btnActualizacionLotes.setFont(new Font("Dialog", Font.BOLD, 30));
		panel2.add(btnActualizacionLotes);
		GridBagConstraints gbc_btnActualizacionLotes = new GridBagConstraints();
		gbc_btnActualizacionLotes.insets = new Insets(0, 0, 0, 30);
		gbc_btnActualizacionLotes.gridx = 4; 
		gbc_btnActualizacionLotes.gridy = 4;
		gbc_btnActualizacionLotes.gridwidth = 4;
		gbc_btnActualizacionLotes.gridheight = 4;
		gbc_btnActualizacionLotes.weighty = 1.0;
		gbc_btnActualizacionLotes.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnActualizacionLotes, gbc_btnActualizacionLotes);
	}
}
