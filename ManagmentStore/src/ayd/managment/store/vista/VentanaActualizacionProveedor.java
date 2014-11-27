package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.Interface.ServicioActualizacionProveedores;


public class VentanaActualizacionProveedor  extends VentanaGenerica {
	//Variables de la clase
	private ServicioActualizacionProveedores servicioActualizacionProveedores;
	//Botones de la clase
	private JButton btnActualizar = new JButton("Actualizar");
	private JButton btnBuscar = new JButton("Buscar");
	//Etiquetas
	private JLabel lblBusqueda = new JLabel("Nombre:");
	private JLabel label1 = new JLabel("");
	private JLabel label2 = new JLabel("");
	private JLabel label3 = new JLabel("");
	private JLabel label4 = new JLabel("");
	private JLabel label5 = new JLabel("");
	private JLabel lblTelefono = new JLabel("Telefono:");
	private JLabel lblTipo = new JLabel("Tipo:");
	//Campos de texto
	private JTextField txtBusqueda = new JTextField("");
	private JTextField txtTelefono = new JTextField("");
	private JTextField txtTipo = new JTextField("");
	
	private int tecla;
	private int punto = 0;
	private int limite = 0;
	private int seleccionar;
	
	public VentanaActualizacionProveedor(ServicioActualizacionProveedores control){
		super("Actualizacion de proveedor","Regresar a ventana \"Proveedores\"");
		servicioActualizacionProveedores = control;
	
		//Asigna formato a los componentes de la ventana
		colocaFormato();
		//Deshabilita los campos que no se pueden editar, especificados en reglas de negocio
		deshabilitaCampos();
		//Inserta los elementos a los paneles
		InsertaEnPanel();
		panel3.add(btnActualizar, BorderLayout.WEST);
		
		
				
		//Actualiza un producto
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Proveedor prov= new Proveedor(txtBusqueda.getText(),txtTelefono.getText(),txtTipo.getText());
				if(servicioActualizacionProveedores.actualizaProveedor(prov)){
					JOptionPane.showMessageDialog(ventana, "Actualizado con exito");
					limpiaCampos();
					ventana.dispose();
				}else{
					JOptionPane.showMessageDialog(ventana, "no se pudo actualizar proveedor");
				}
			}
		});
		
		//boton salir o cancelar
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnActualizar.setEnabled(false);
				limpiaCampos();
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Proveedor prov=servicioActualizacionProveedores.regresaProveedor(txtBusqueda.getText());
				if(prov==null){
					limpiaCampos();
					JOptionPane.showMessageDialog(ventana, "proveedor no encontrado");
				}else{
					txtBusqueda.setText(prov.getProveedor());
					txtTelefono.setText(prov.getTelefono());
					txtTipo.setText(prov.getTipo());
					btnActualizar.setEnabled(true);
				}
			}
		});
	}
	
	//asigna formato a los componentes de la ventana
	private void colocaFormato(){
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 30));
		btnBuscar.setFont(new Font("Dialog",Font.BOLD, 28));
		lblBusqueda.setFont(new Font("Dialog", Font.BOLD, 28));
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 28));
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 28));	
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtBusqueda.setFont(new Font("Dialog", Font.BOLD, 28));		
		txtTelefono.setFont(new Font("Dialog", Font.BOLD, 28));
		txtTipo.setFont(new Font("Dialog", Font.BOLD, 28));
		}
	
	//deshabilita campos que no se deben editar, especificado en reglas de negocio	
	private void deshabilitaCampos(){
		btnActualizar.setEnabled(false);
	}
	
	//deja la ventana limpia
	private void limpiaCampos(){
		txtBusqueda.setText("");
		txtTelefono.setText("");
		txtTipo.setText("");	
	}
	
	//inserta los componentes en la ventana
	private void InsertaEnPanel(){
		panel2.setLayout(new GridLayout(0, 3, 20, 10));
		panel2.add(lblBusqueda);
		panel2.add(txtBusqueda);
		panel2.add(btnBuscar);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(lblTelefono);
		panel2.add(txtTelefono);
		panel2.add(label2);
		panel2.add(lblTipo);
		panel2.add(txtTipo);
		panel2.add(label1);
			
	}
	
	//Omite caracteres invalidos
	private void  validaCadenayEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 33 && tecla <= 45 || tecla == 47 || tecla >= 58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
	    	e.consume();
	}
	
	
	//valida que todos los campos esten con datos
	private boolean camposLlenos(){
		if(txtTipo.getText().isEmpty() || txtTelefono.getText().isEmpty())
			return false;
		else
			return true;
	}
	
}
