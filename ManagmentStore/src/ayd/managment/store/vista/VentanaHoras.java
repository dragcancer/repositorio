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
public class VentanaHoras extends VentanaGenerica{
	
	private Aplicacion app;
	
	public VentanaHoras(Aplicacion control) {
		super("Registrs","Regresar a ventana \"Principal\"");
		app = control;
		
		//Asigno un Layaout para organizar los elementos en la ventana
		panel2.setLayout(new GridBagLayout());
		
		//Creo botones y los coloco segun mi conveniencia con el Layaout seleccionado
		JButton btnHoraEntrada = new JButton("Registrar Hora de entrada");
		btnHoraEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.HoraEntrada();
			}
		});
		btnHoraEntrada.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 0, 30);
		gbc_btnAlta.gridx = 0; 
		gbc_btnAlta.gridy = 0;
		gbc_btnAlta.gridwidth = 3;
		gbc_btnAlta.gridheight = 4;
		gbc_btnAlta.weighty = 1.0;
		gbc_btnAlta.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnHoraEntrada, gbc_btnAlta);

		
		
		JButton btnHoraSalida = new JButton("Registrar Hora de salida");
		btnHoraSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.HoraSalida();
			}
		});
		btnHoraSalida.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 0, 30);
		gbc_btnBaja.gridx = 0; 
		gbc_btnBaja.gridy = 4;
		gbc_btnBaja.gridwidth = 4;
		gbc_btnBaja.gridheight = 4;
		gbc_btnBaja.weighty = 1.0;
		gbc_btnBaja.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnHoraSalida, gbc_btnBaja);
		
		JButton btnGastos = new JButton("Registrar gastos");
		btnGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.registroGastos();
			}
		});
		btnGastos.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnGastos = new GridBagConstraints();
		gbc_btnGastos.insets = new Insets(0, 0, 0, 30);
		gbc_btnGastos.gridx = 0; 
		gbc_btnGastos.gridy = 8;
		gbc_btnGastos.gridwidth = 4;
		gbc_btnGastos.gridheight = 4;
		gbc_btnGastos.weighty = 1.0;
		gbc_btnGastos.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnGastos, gbc_btnGastos);
		
	}
}
