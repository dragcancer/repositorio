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

import ayd.managment.store.servicio.Interface.ServicioBajaProducto;


//Heredo de VentanaGenerica
public class VentanaBajaProducto extends VentanaGenerica{
	//Variables de la clase
	private ServicioBajaProducto servicioBajaProducto;
	//Botones de la clase
	private JButton btnBaja = new JButton("Dar de baja");
	//Etiquetas
	private JLabel lblBusqueda = new JLabel("Ingrese el código/nombre del producto:");
	private JLabel label1 = new JLabel("");
	private JLabel label2 = new JLabel("");
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblCodigo = new JLabel("Código:");
	private JLabel lblPrecioCompra = new JLabel("Precio compra:");
	private JLabel lblPrecioMenudeo = new JLabel("Precio menudeo:");
	private JLabel lblPrecioMayoreo = new JLabel("Precio mayoreo:");
	private JLabel lblCantidadMayoreo = new JLabel("Cantidad mayoreo:");
	private JLabel lblProveedor = new JLabel("Proveedor:");
	private JLabel lblExistenciaActual = new JLabel("Existencia actual:");
	private JLabel lblExistenciaMinima = new JLabel("Existencia mínima:");
	private JLabel lblExistenciaMaxima = new JLabel("Existencia máxima:");
	private JLabel lblTipo = new JLabel("Tipo:");
	//Campos de texto
	private JTextField txtBusqueda = new JTextField("");
	private JTextField txtCodigo = new JTextField("");
	private JTextField txtNombre = new JTextField("");
	private JTextField txtPrecioCompra = new JTextField("");
	private JTextField txtPrecioMenudeo = new JTextField("");
	private JTextField txtPrecioMayoreo = new JTextField("");
	private JTextField txtCantidadMayoreo = new JTextField("");
	private JTextField txtProveedor = new JTextField("");
	private JTextField txtExistenciaActual = new JTextField("");
	private JTextField txtExistenciaMinima = new JTextField("");
	private JTextField txtExistenciaMaxima = new JTextField("");
	//ComboBox
	private JComboBox<String> cbxTipo = new JComboBox<String>(new javax.swing.DefaultComboBoxModel<String>(new String[] {"A granel","Pieza"}));
	//Variables de la clase
	private int tecla;
	
	public VentanaBajaProducto(ServicioBajaProducto control){
		super("Baja de producto","Regresar a ventana \"Productos\"");
		servicioBajaProducto = control;
		
		//Asigna formato a los componentes de la ventana
		colocaFormato();
		//Deshabilita los campos que no se pueden editar, especificados en reglas de negocio
		deshabilitaCampos();
		//Inserta los elementos a los paneles
		InsertaEnPanel();

		//Omite caracteres invalidos
		txtBusqueda.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaCadenayEntero(txtBusqueda.getText(), e);
				if((int)e.getKeyChar() == 10 && !txtBusqueda.getText().isEmpty())
					buscar();
			}
		});
		//Lanza una confirmacion para dar de baja un producto si se selecciona la opcion si
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(ventana, "¿Esta seguro que desea eliminar al producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
	            if(resp == JOptionPane.YES_NO_OPTION)       
	            	darDeBaja();
			}
		});
		
		//boton salir o cancelar
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBaja.setEnabled(false);
				limpiaCampos();
			}
		});
	}	
	
	//asigna formato a los componentes de la ventana
	private void colocaFormato(){
		btnBaja.setFont(new Font("Dialog", Font.BOLD, 30));
		lblBusqueda.setFont(new Font("Dialog", Font.BOLD, 28));
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPrecioCompra.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPrecioMenudeo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPrecioMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblCantidadMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblProveedor.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExistenciaActual.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExistenciaMinima.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExistenciaMaxima.setFont(new Font("Dialog", Font.BOLD, 28));
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtBusqueda.setFont(new Font("Dialog", Font.BOLD, 28));
		txtCodigo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		txtPrecioCompra.setFont(new Font("Dialog", Font.BOLD, 28));
		txtPrecioMenudeo.setFont(new Font("Dialog", Font.BOLD, 28));	
		txtPrecioMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtCantidadMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtProveedor.setFont(new Font("Dialog", Font.BOLD, 28));
		txtExistenciaActual.setFont(new Font("Dialog", Font.BOLD, 28));
		txtExistenciaMinima.setFont(new Font("Dialog", Font.BOLD, 28));
		txtExistenciaMaxima.setFont(new Font("Dialog", Font.BOLD, 28));
		cbxTipo.setFont(new Font("Dialog", Font.BOLD, 28));
	}
	
	//Deshabilita campos que no se deben editar, especificado en reglas de negocio	
	private void deshabilitaCampos(){
		btnBaja.setEnabled(false);
		txtCodigo.setEditable(false);
		txtNombre.setEditable(false);
		txtPrecioCompra.setEditable(false);
		txtPrecioMenudeo.setEditable(false);	
		txtPrecioMayoreo.setEditable(false);
		txtCantidadMayoreo.setEditable(false);
		txtProveedor.setEditable(false);
		txtExistenciaActual.setEditable(false);
		txtExistenciaMinima.setEditable(false);
		txtExistenciaMaxima.setEditable(false);
		cbxTipo.setEnabled(false);
	}
		
	//Deja la ventana limpio los campos de texto
	private void limpiaCampos(){
		txtBusqueda.setText("");
		txtCodigo.setText("");
		txtNombre.setText("");	
		txtPrecioCompra.setText("");	
		txtPrecioMenudeo.setText("");
		txtPrecioMayoreo.setText("");	
		txtCantidadMayoreo.setText("");	
		txtProveedor.setText("");
		txtExistenciaActual.setText("");
		txtExistenciaMinima.setText("");
		txtExistenciaMaxima.setText("");
	}
		
	//Inserta los componentes en la ventana
	private void InsertaEnPanel(){
		panel2.setLayout(new GridLayout(0, 2, 20, 10));
		panel2.add(lblBusqueda);
		panel2.add(txtBusqueda);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(lblCodigo);
		panel2.add(txtCodigo);	
		panel2.add(lblNombre);
		panel2.add(txtNombre);
		panel2.add(lblPrecioCompra);
		panel2.add(txtPrecioCompra);
		panel2.add(lblPrecioMenudeo);
		panel2.add(txtPrecioMenudeo);
		panel2.add(lblPrecioMayoreo);
		panel2.add(txtPrecioMayoreo);
		panel2.add(lblCantidadMayoreo);
		panel2.add(txtCantidadMayoreo);
		panel2.add(lblProveedor);
		panel2.add(txtProveedor);
		panel2.add(lblExistenciaActual);
		panel2.add(txtExistenciaActual);
		panel2.add(lblExistenciaMinima);
		panel2.add(txtExistenciaMinima);
		panel2.add(lblExistenciaMaxima);
		panel2.add(txtExistenciaMaxima);
		panel2.add(lblTipo);
		panel2.add(cbxTipo);
		panel3.add(btnBaja, BorderLayout.WEST);
	}
	
	//Omite caracteres invalidos
	private void  validaCadenayEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 33 && tecla <= 45 || tecla == 47 || tecla >= 58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
	    	e.consume();
	}
	
	
	//Muestra los datos en pantalla, de un producto que se ha encontrado
	private void despliegaDatos(){
		String datos[] = new String[11];
		datos = servicioBajaProducto.mostrarDatos();
		txtCodigo.setText(datos[0]);
		txtNombre.setText(datos[1]);	
		txtPrecioCompra.setText(datos[2]);	
		txtPrecioMenudeo.setText(datos[3]);
		txtPrecioMayoreo.setText(datos[4]);	
		txtCantidadMayoreo.setText(datos[5]);	
		txtProveedor.setText(datos[6]);
		txtExistenciaActual.setText(datos[7]);
		txtExistenciaMinima.setText(datos[8]);
		txtExistenciaMaxima.setText(datos[9]);
		cbxTipo.setSelectedIndex(Integer.parseInt(datos[10]));
	}
	//Este metodo se ejecuta cada vez que la tecla "enter" se preciona	
	private void buscar(){
		if(servicioBajaProducto.buscarProducto(txtBusqueda.getText())){
			//Producto encontrado, se imprimen los datos en pantalla
			despliegaDatos();
			btnBaja.setEnabled(true);
		}
		else{
			//Producto NO encontrado
			JOptionPane.showMessageDialog(ventana,"El producto con ese código/nombre no existe.\nPor favor verifique.","Error",JOptionPane.ERROR_MESSAGE);
			limpiaCampos();
		}
	}
	//Se ejecuta si la opcion de la baja del producto es "si"
	private void darDeBaja(){
		//Muestra mensaje de exito al eleminiar el producto
		if(servicioBajaProducto.darDeBajaProducto()){
			JOptionPane.showMessageDialog(ventana,"El Producto ha sido dado de baja con exito");
			limpiaCampos();
			btnBaja.setEnabled(false);
			ventana.dispose();
		}
		//Muestra mensaje de error al eleminiar el producto
		else
		JOptionPane.showMessageDialog(ventana,"No se pudo dar de baja al producto.","Error",JOptionPane.ERROR_MESSAGE);
	}	
}