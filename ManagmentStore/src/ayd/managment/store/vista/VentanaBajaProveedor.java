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

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.clase.ServicioBajaProveedorClase;

public class VentanaBajaProveedor extends VentanaGenerica {
	private static final long serialVersionUID = 1L;
	private ServicioBajaProveedorClase bajaProveedor;
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnBaja = new JButton("Dar de baja");
	private JTextField txtNombre = new JTextField("");
	private Proveedor proveedor;
	private String auxprov;
	
	public VentanaBajaProveedor(ServicioBajaProveedorClase control){
		super("Baja de proveedor","Regresar a ventana \"Proveedores\"");
		bajaProveedor = control;
		btnBaja.setEnabled(false);
		
		//Asigno un Layaout para organizar los elementos en la ventana

		panel2.setLayout(new GridBagLayout());
		
		JLabel lblCodigo = new JLabel("Ingrese nombre de proveedor a buscar:");
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
		
		
		JLabel lblNombre = new JLabel("Información de proveedor:");
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
				auxprov=txtCodigo.getText();
				proveedor=bajaProveedor.verificaProveedor(auxprov);
					if(proveedor==null){				
						JOptionPane.showMessageDialog(ventana, "No se encontro proveedor");
					}else{
						txtNombre.setText(""+proveedor.getProveedor()+"   "+proveedor.getTelefono()+"    "+proveedor.getTipo());
						btnBaja.setEnabled(true);
					}
					
			}
		});
		
		
		btnBaja.setFont(new Font("Dialog", Font.BOLD, 30));
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(bajaProveedor.BajaProveedor(auxprov)){
						JOptionPane.showMessageDialog(null, "Baja con exito	");
						txtCodigo.setText("");
						txtNombre.setText("");
						ventana.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo dar de baja");
						txtCodigo.setText("");
						txtNombre.setText("");
					}
			}
		});
		panel3.add(btnBaja, BorderLayout.WEST);
	}		

}
