package ayd.managment.store.vista;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ayd.managment.store.principal.Aplicacion;

//Heredo de VentanaGenerica
public class VentanaUsuarios extends VentanaGenerica{
	
	private Aplicacion app;

	public VentanaUsuarios(Aplicacion control){
		super("Empleados","Regresar a ventana \"Principal\"");
		app = control;
		
		//Asigno un Layaout para organizar los elementos en la ventana
		panel2.setLayout(new GridBagLayout());
				
		//Creo botones y los coloco segun mi conveniencia con el Layaout seleccionado
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.altaUsuarios();
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
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.bajaUsuarios();
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

		
		
		
		JButton btnActualizacion = new JButton("Actualización");
		btnActualizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.actualizacionUsuarios();
			}
		});
		btnActualizacion.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnActualizacion = new GridBagConstraints();
		gbc_btnActualizacion.insets = new Insets(0, 0, 0, 30);
		gbc_btnActualizacion.gridx = 0; 
		gbc_btnActualizacion.gridy = 4;
		gbc_btnActualizacion.gridwidth = 3;
		gbc_btnActualizacion.gridheight = 3;
		gbc_btnActualizacion.weighty = 1.0;
		gbc_btnActualizacion.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnActualizacion, gbc_btnActualizacion);
		
		JButton btnGenerarHoras = new JButton("Generar horas");
		btnGenerarHoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.generarHoras();
			}
		});
		btnGenerarHoras.setFont(new Font("Dialog", Font.BOLD, 30));
		panel2.add(btnGenerarHoras);
		GridBagConstraints gbc_btnGenerarHoras = new GridBagConstraints();
		gbc_btnGenerarHoras.insets = new Insets(0, 0, 0, 30);
		gbc_btnGenerarHoras.gridx = 4; 
		gbc_btnGenerarHoras.gridy = 4;
		gbc_btnGenerarHoras.gridwidth = 3;
		gbc_btnGenerarHoras.gridheight = 3;
		gbc_btnGenerarHoras.weighty = 1.0;
		gbc_btnGenerarHoras.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnGenerarHoras, gbc_btnGenerarHoras);
		
		
		JButton btnHoraEntrada = new JButton("Hora de Entrada");
		btnHoraEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.HoraEntrada();
			}
		});
		btnHoraEntrada.setFont(new Font("Dialog", Font.BOLD, 30));
		panel2.add(btnHoraEntrada);
		GridBagConstraints gbc_btnHoraEntrada = new GridBagConstraints();
		gbc_btnHoraEntrada.insets = new Insets(0, 0, 0, 30);
		gbc_btnHoraEntrada.gridx = 0; 
		gbc_btnHoraEntrada.gridy = 8;
		gbc_btnHoraEntrada.gridwidth = 3;
		gbc_btnHoraEntrada.gridheight = 3;
		gbc_btnHoraEntrada.weighty = 1.0;
		gbc_btnHoraEntrada.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnHoraEntrada, gbc_btnHoraEntrada);
		
		JButton btnHoraSalida = new JButton("Hora de Salida");
		btnHoraSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.HoraSalida();
			}
		});
		btnHoraSalida.setFont(new Font("Dialog", Font.BOLD, 30));
		panel2.add(btnHoraSalida);
		GridBagConstraints gbc_btnHoraSalida = new GridBagConstraints();
		gbc_btnHoraSalida.insets = new Insets(0, 0, 0, 30);
		gbc_btnHoraSalida.gridx = 4; 
		gbc_btnHoraSalida.gridy = 8;
		gbc_btnHoraSalida.gridwidth = 3;
		gbc_btnHoraSalida.gridheight = 3;
		gbc_btnHoraSalida.weighty = 1.0;
		gbc_btnHoraSalida.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnHoraSalida, gbc_btnHoraSalida);

		

	}
}

