package ayd.managment.store.vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ayd.managment.store.principal.Aplicacion;

//Heredo de VentanaGenerica
public class VentanaGenerarReportes extends VentanaGenerica{
	
	private Aplicacion app;

	public VentanaGenerarReportes(Aplicacion control){
		super("Generar reportes","Regresar a ventana \"Principal\"");
		app = control;
		
		//Asigno un Layaout para organizar los elementos en la ventana
		panel2.setLayout(new GridBagLayout());
			
		//Creo botones y los coloco segun mi conveniencia con el Layaout seleccionado
		JButton btnReporteVentaDia = new JButton("Generar Reporte De Venta del día");
		btnReporteVentaDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.reportesVentasDia();
			}
		});
		btnReporteVentaDia.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnReporteVentaDia = new GridBagConstraints();
		gbc_btnReporteVentaDia.insets = new Insets(0, 0, 0, 30);
		gbc_btnReporteVentaDia.gridx = 0; 
		gbc_btnReporteVentaDia.gridy = 0;
		gbc_btnReporteVentaDia.gridwidth = 4;
		gbc_btnReporteVentaDia.gridheight = 4;
		gbc_btnReporteVentaDia.weighty = 1.0;
		gbc_btnReporteVentaDia.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnReporteVentaDia, gbc_btnReporteVentaDia);

		JButton btnOtro1 = new JButton("Generar reporte de venta por mes");
		btnOtro1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.reporteMes();	
			}
		});
		btnOtro1.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnOtro1 = new GridBagConstraints();
		gbc_btnOtro1.insets = new Insets(0, 0, 0, 30);
		gbc_btnOtro1.gridx = 4; 
		gbc_btnOtro1.gridy = 0;
		gbc_btnOtro1.gridwidth = 4;
		gbc_btnOtro1.gridheight = 4;
		gbc_btnOtro1.weighty = 1.0;
		gbc_btnOtro1.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnOtro1, gbc_btnOtro1);
		
		JButton btnOtro2 = new JButton("Reporte de gastos");
		btnOtro2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					app.reporteGastos();
			}
		});
		btnOtro2.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnOtro2 = new GridBagConstraints();
		gbc_btnOtro2.insets = new Insets(0, 0, 0, 30);
		gbc_btnOtro2.gridx = 0; 
		gbc_btnOtro2.gridy = 4;
		gbc_btnOtro2.gridwidth = 4;
		gbc_btnOtro2.gridheight = 4;
		gbc_btnOtro2.weighty = 1.0;
		gbc_btnOtro2.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnOtro2, gbc_btnOtro2);
		
		JButton btnOtro3 = new JButton("Otro");
		btnOtro3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			}
		});
		btnOtro3.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnOtro3 = new GridBagConstraints();
		gbc_btnOtro3.insets = new Insets(0, 0, 0, 30);
		gbc_btnOtro3.gridx = 4; 
		gbc_btnOtro3.gridy = 4;
		gbc_btnOtro3.gridwidth = 4;
		gbc_btnOtro3.gridheight = 4;
		gbc_btnOtro3.weighty = 1.0;
		gbc_btnOtro3.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnOtro3, gbc_btnOtro3);
	}	
}
