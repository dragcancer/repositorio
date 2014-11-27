package ayd.managment.store.vista;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ayd.managment.store.servicio.clase.ServicioBajaUsuarioClase;;

//Heredo de VentanaGenerica
public class VentanaBajaUsuario extends VentanaGenerica{
	private ServicioBajaUsuarioClase bajaUsuario;
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnBaja = new JButton("Dar de baja");
	private JTextField txtNombre = new JTextField("");
	
	public VentanaBajaUsuario(ServicioBajaUsuarioClase control){
		super("Baja de empleado","Regresar a ventana \"Empleados\"");
		bajaUsuario = control;
		btnBaja.setEnabled(false);
		
		//Asigno un Layaout para organizar los elementos en la ventana

		panel2.setLayout(new GridBagLayout());
		
		JLabel lblCodigo = new JLabel("Ingrese código del empleado a buscar:");
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCodigo.doLayout();
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.insets = new Insets(0, 0, 0, 30);
		gbc_lblCodigo.gridx = 0; 
		gbc_lblCodigo.gridy = 0; 
		gbc_lblCodigo.gridwidth = 1;
		gbc_lblCodigo.gridheight = 1;
		gbc_lblCodigo.weighty = 1.0;
		gbc_lblCodigo.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(lblCodigo, gbc_lblCodigo);
		
		final JTextField txtCodigo = new JTextField("");
		//txtCodigo.setSize(300, 100);
		txtCodigo.setFont(new Font("Dialog", Font.BOLD, 30));
		txtCodigo.doLayout();
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.insets = new Insets(0, 0, 0, 30);
		gbc_txtCodigo.gridx = 3; 
		gbc_txtCodigo.gridy = 0; 
		gbc_txtCodigo.gridwidth = 3;
		gbc_txtCodigo.gridheight = 3;
		gbc_txtCodigo.weighty = 1.0;
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(txtCodigo, gbc_txtCodigo);
		
		
		JLabel lblNombre = new JLabel("Información del empleado:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNombre.doLayout();
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 30);
		gbc_lblNombre.gridx = 0; 
		gbc_lblNombre.gridy = 6; 
		gbc_lblNombre.gridwidth = 1;
		gbc_lblNombre.gridheight = 1;
		gbc_lblNombre.weighty = 1.0;
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(lblNombre, gbc_lblNombre);
		
		
		
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 0, 30);
		gbc_txtNombre.gridx = 0; 
		gbc_txtNombre.gridy = 7; 
		gbc_txtNombre.gridwidth = 8;
		gbc_txtNombre.gridheight = 8;
		gbc_txtNombre.weighty = 8.0;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(txtNombre, gbc_txtNombre);
		
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 30);
		gbc_btnBuscar.gridx = 3; 
		gbc_btnBuscar.gridy = 1; 
		gbc_btnBuscar.gridwidth = 3;
		gbc_btnBuscar.gridheight = 3;
		gbc_btnBuscar.weighty = 1.0;
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnBuscar, gbc_btnBuscar);
		
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuarioId=txtCodigo.getText().toString();
				if(bajaUsuario.buscarUsuario(usuarioId)!=null){
					//String informacion=bajaUsuario.
					txtNombre.setText(bajaUsuario.buscarUsuario(usuarioId).getCodigoEmpleado()+" / "+bajaUsuario.buscarUsuario(usuarioId).getNombre()+" "+bajaUsuario.buscarUsuario(usuarioId).getApellidoPaterno()+" "+bajaUsuario.buscarUsuario(usuarioId).getApellidoMaterno());
					btnBaja.setEnabled(true);
				}else{
					JOptionPane.showMessageDialog(ventana,"No se encontró al empleado","Error",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		
		btnBaja.setFont(new Font("Dialog", Font.BOLD, 30));
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuarioId=txtCodigo.getText().toString();
				int resp = JOptionPane.showConfirmDialog(ventana,"¿Esta seguro que desea eliminar al contacto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_NO_OPTION){
					if(bajaUsuario.BajaUsuario(usuarioId)){
						JOptionPane.showMessageDialog(ventana, "Se eliminó al empleado de forma exitosa");
						ventana.dispose();
					}
					else
						JOptionPane.showMessageDialog(ventana, "Surgió un problema o no se encontró al empleado");
				}
			}
		});
		panel3.add(btnBaja, BorderLayout.WEST);
	}		
}
